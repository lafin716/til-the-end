package com.lafin.tiltheend.controller;


import com.lafin.tiltheend.thirdparty.notion.NotionClient;
import com.lafin.tiltheend.thirdparty.notion.service.NotionService;
import com.lafin.tiltheend.thirdparty.notion.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final NotionClient notionClient;

    @GetMapping("/pages/{pageId}")
    public String hello(@PathVariable String pageId) {
        return notionClient.getPage().retrieve("851676d8c99042d4b46ed0c44334188a").toString();
    }
}
