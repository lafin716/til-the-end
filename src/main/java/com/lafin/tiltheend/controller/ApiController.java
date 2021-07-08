package com.lafin.tiltheend.controller;


import com.lafin.tiltheend.service.BlockTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final BlockTransferService blockTransferService;

//    @GetMapping("/pages/{pageId}")
//    public PageResponse pages(@PathVariable(required = true) String pageId) {
//        return notionClient.getPage().retrieve(pageId);
//    }

    @GetMapping("/blocks/{pageId}")
    public List<String> blocks(@PathVariable(required = true) String pageId) {
        return blockTransferService.getBlockListToString(pageId, null);
//        return notionClient.getBlock().retrieve(pageId, null);
    }
}
