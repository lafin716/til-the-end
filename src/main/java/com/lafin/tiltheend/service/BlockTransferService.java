package com.lafin.tiltheend.service;

import com.lafin.tiltheend.dto.BlockDto;
import com.lafin.tiltheend.thirdparty.notion.NotionClient;
import com.lafin.tiltheend.thirdparty.notion.dto.request.BlockRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PaginationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlockTransferService {

    private final NotionClient notionClient;

    public List<BlockDto> getBlockListToString(String pageId, BlockRequest blockRequest) {
        PaginationResponse<BlockResponse> blockResponse = notionClient.getBlock().retrieve(pageId, blockRequest);
        var list = new ArrayList<BlockDto>();

        blockResponse.getResults().forEach((data) -> {
            var block = new BlockDto();
            block.setType(data.getType());
            if (data.isHasChildren()) {
                data.getChild().getText().forEach((child) -> {
                    block.setText(child.getPlainText());
                    list.add(block);
                });
            }
        });

        return list;
    }
}
