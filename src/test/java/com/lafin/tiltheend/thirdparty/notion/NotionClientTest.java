package com.lafin.tiltheend.thirdparty.notion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Test
    void retrievePageTest() {
        var result = notionClient.getPage().retrieve("851676d8c99042d4b46ed0c44334188a").toString();

        System.out.println(result);
    }

    @Test
    void createPageTest() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource("json/create_page.json");

            PageRequest<PageParent> pageRequest = objectMapper.readValue(resource.getFile(), new TypeReference<PageRequest<PageParent>>(){});

            var result = notionClient.getPage().createFromPage(pageRequest);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void retrieveBlockTest() throws JsonProcessingException {
        var result = notionClient.getBlock().retrieveRaw("851676d8c99042d4b46ed0c44334188a");

        ObjectMapper objectMapper = new ObjectMapper();
        var json = objectMapper.writeValueAsString(result);

        System.out.println(result);
        System.out.println(json);
    }
}