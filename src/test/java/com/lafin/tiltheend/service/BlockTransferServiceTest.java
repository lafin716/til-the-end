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
        var result = blockTransferService.getBlockListToString("e91bbe13863d44f79828f3586d52c05f", null);

        System.out.println(result);
    }
}