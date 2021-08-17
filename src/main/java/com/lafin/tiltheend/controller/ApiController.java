package com.lafin.tiltheend.controller;


import com.lafin.tiltheend.dto.BlockDto;
import com.lafin.tiltheend.service.BlockTransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<String> getBlockText(@PathVariable(required = true) String pageId) {
        return blockTransferService.getBlockListToString(pageId, null);
    }

    @PostMapping("/posting/{pageId}")
    public String postToGithub(@PathVariable(required = true) String pageId) {
        return blockTransferService.postGithubFromNotion(pageId);
    }
}
