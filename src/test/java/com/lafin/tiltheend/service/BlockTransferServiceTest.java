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
    void getText() {
        var result = blockTransferService.getBlocksToString("851676d8c99042d4b46ed0c44334188a", null);
        System.out.println(result);
    }

    @Test
    void getPageTitle() {
        System.out.println(blockTransferService.getPageTitle("fcdc1fde-6313-4c64-a3a3-cb65cad11555"));
    }

    @Test
    void postToGithubTest() {
        var result = blockTransferService.postGithubFromNotion("851676d8c99042d4b46ed0c44334188a");

        System.out.println(result);
    }
}