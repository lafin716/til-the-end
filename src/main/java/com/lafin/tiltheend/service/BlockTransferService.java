package com.lafin.tiltheend.service;

import com.lafin.tiltheend.constant.NotionBlockType;
import com.lafin.tiltheend.dto.BlockDto;
import com.lafin.tiltheend.thirdparty.github.GithubClient;
import com.lafin.tiltheend.thirdparty.notion.NotionClient;
import com.lafin.tiltheend.thirdparty.notion.dto.request.BlockRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PaginationResponse;
import com.lafin.tiltheend.util.MarkDownUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlockTransferService {

    private final NotionClient notionClient;

    private final GithubClient githubClient;

    // 노션 페이지 내 블럭들을 마크다운으로 변환하여 리스트 형태로 리턴
    public List<String> getBlockListToString(String pageId, BlockRequest blockRequest) {
        PaginationResponse<BlockResponse> blockResponse = notionClient.getBlock().retrieve(pageId, blockRequest);

        var list = new ArrayList<String>();

        var result = blockResponse.getResults();

        for (BlockResponse response : result) {
            var block = new BlockDto();
            block.setId(response.getId());
            block.setType(NotionBlockType.from(response.getType()));
            if (!ObjectUtils.isEmpty(response.getChild()) && !ObjectUtils.isEmpty(response.getChild().getText())) {
                block.setText(response.getChild().getText().get(0).getPlainText());
            }

            list.add(MarkDownUtils.translate(block));
        }

        return list;
    }

    // 페이지 제목 가져오기
    public String getPageTitle(String pageId) {
        var response = notionClient.getPage().retrieve(pageId);
        return response.getProperties().getTitle().getTitle().get(0).getPlainText();
    }

    // 노션 페이지 내 블럭들을 마크다운으로 변환하여 텍스트 형태로 리턴
    public String getBlocksToString(String pageId, BlockRequest blockRequest) {
        PaginationResponse<BlockResponse> blockResponse = notionClient.getBlock().retrieve(pageId, blockRequest);

        var blocks = new StringBuilder();

        var result = blockResponse.getResults();

        for (BlockResponse response : result) {
            var block = new BlockDto();
            block.setId(response.getId());
            block.setType(NotionBlockType.from(response.getType()));

            if (!ObjectUtils.isEmpty(response.getChild()) && !ObjectUtils.isEmpty(response.getChild().getText())) {
                block.setText(response.getChild().getText().get(0).getPlainText());
            } else if (block.getType() == NotionBlockType.CHILD_PAGE) {
                block.setText(getPageTitle(response.getId()));
                block.setUrl(notionClient.getBlock().getHomeUrl() + response.getId().replaceAll("-", ""));
            }

            blocks.append(MarkDownUtils.translate(block) + "\n");
        }

        return blocks.toString();
    }

    // 노션 페이지 항목을 읽어온 뒤 Github에 새 페이지 생성하여 커밋 처리
    public String postGithubFromNotion(String pageId) {
        LocalDate today = LocalDate.now();
        String year = today.format(DateTimeFormatter.ofPattern("yyyy"));
        String date = today.format(DateTimeFormatter.ofPattern("MMdd"));
        String pageTitle = "#" + getPageTitle(pageId);
        var path = year + "/" + date + ".md";
        var title = "docs : Add TIL " + pageTitle + " At " + LocalDateTime.now().toString();
        var content = pageTitle + getBlocksToString(pageId, null);
        var result = githubClient.getRepository().preparedCommit(path, title, content);

        return result;
    }

}
