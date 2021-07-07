package com.lafin.tiltheend.thirdparty.notion.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lafin.tiltheend.library.resttemplate.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PageServiceTest {

    @Autowired
    private PageService pageService;

    @Test
    void retrieveTest() {
        Map response = pageService.retrieveRaw("851676d8c99042d4b46ed0c44334188a");
//        Map response = pageService.retrieveRaw("d2514522f1cf4b92980030ea8badc0b2");

        objectToJson(response);
    }

    private void objectToJson(Object object) {

        var objectMapper = new ObjectMapper();
        String result = null;

        try {
            result = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}