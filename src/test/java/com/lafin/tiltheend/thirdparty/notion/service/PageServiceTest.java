package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.library.resttemplate.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PageServiceTest {

    @Autowired
    private PageService pageService;

    @Test
    void retrieveTest() {
        Response response = pageService.retrieve("851676d8c99042d4b46ed0c44334188a");

        System.out.println(response);
    }
}