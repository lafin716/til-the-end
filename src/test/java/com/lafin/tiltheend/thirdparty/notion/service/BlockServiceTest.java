package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.library.resttemplate.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockServiceTest {

    @Autowired
    private BlockService blockService;

    @Autowired
    private JsonUtil jsonUtil;

    @Test
    void retrieveBlockTest() {
        var result = blockService.retrieveRaw("851676d8c99042d4b46ed0c44334188a");

        var text = jsonUtil.objectToJson(result);

        System.out.println(text);

    }

}