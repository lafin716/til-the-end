package com.lafin.tiltheend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockTransferServiceTest {

    @Autowired
    private BlockTransferService blockTransferService;

    @Test
    void getList() {
        var result = blockTransferService.getBlockListToString("851676d8c99042d4b46ed0c44334188a", null);

        System.out.println(result);
    }

    @Test
    void postToGithubTest() {
        var result = blockTransferService.postGithubFromNotion("851676d8c99042d4b46ed0c44334188a");

        System.out.println(result);
    }
}