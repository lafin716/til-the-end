package com.lafin.tiltheend.service;

import com.lafin.tiltheend.thirdparty.notion.NotionClient;
import com.lafin.tiltheend.thirdparty.notion.dto.request.BlockRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockTransferService {

    private final NotionClient notionClient;

    public List<String> getBlockListToString(String pageId, BlockRequest blockRequest) {
        PaginationResponse<BlockResponse> blockResponse = notionClient.getBlock().retrieve(pageId, blockRequest);
        var list = new ArrayList<String>();

        blockResponse.getResults().forEach((data) -> {
            data.getChild().getText().forEach((child) -> {
                list.add(child.getPlainText());
            });
        });

        return list;
    }
}
