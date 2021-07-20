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
        var result = blockTransferService.getBlockListToString("0bad843e1e0141fab20d9b002b2cab08", null);

        System.out.println(result);
    }
}