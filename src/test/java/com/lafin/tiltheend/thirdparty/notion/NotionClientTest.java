package com.lafin.tiltheend.thirdparty.notion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lafin.tiltheend.library.resttemplate.JsonUtil;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageParent;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PageResponse;
import com.lafin.tiltheend.thirdparty.notion.service.PageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class NotionClientTest {

    @Autowired
    private NotionClient notionClient;

    @Autowired
    private JsonUtil jsonUtil;

    @Test
    void retrievePageTest() {
        var result = notionClient.getPage().retrieveRaw("851676d8c99042d4b46ed0c44334188a").toString();

        System.out.println(jsonUtil.objectToJson(result));
    }

    @Test
    void createPageTest() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource("json/create_page.json");

            PageRequest pageRequest = objectMapper.readValue(resource.getFile(), PageRequest.class);

            var result = notionClient.getPage().createFromPage(pageRequest);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void retrieveBlockTest() {
//        var result = notionClient.getBlock().retrieveRaw("851676d8c99042d4b46ed0c44334188a");
        var result = notionClient.getBlock().retrieve("851676d8c99042d4b46ed0c44334188a", null);

        System.out.println(jsonUtil.objectToJson(result));
    }
}