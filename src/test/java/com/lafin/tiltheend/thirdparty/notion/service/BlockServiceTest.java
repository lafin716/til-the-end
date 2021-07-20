package com.lafin.tiltheend.thirdparty.notion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lafin.tiltheend.library.resttemplate.JsonUtil;
import com.lafin.tiltheend.thirdparty.notion.dto.request.BlockRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockProperties;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
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
        var result = blockService.retrieve("851676d8c99042d4b46ed0c44334188a", null);

        var text = jsonUtil.objectToJson(result);

        System.out.println(text);
    }

    @Test
    void retrieveBlockRawTest() {
        var result = blockService.retrieveRaw("0bad843e1e0141fab20d9b002b2cab08");

        var text = jsonUtil.objectToJson(result);

        System.out.println(text);
    }

    @Test
    void appendBlockTest() {
        var newBlock = new BlockRequest();
        var newBlockProperties = new BlockResponse();
        var blockProperty = new BlockProperties();
        var blockText = new BlockProperties.Properties();
        var text2 = new BlockProperties.Properties.Text();
        var textList = new ArrayList<BlockProperties.Properties>();
        var list = new ArrayList<BlockResponse>();

        newBlockProperties.setObject("block");
        newBlockProperties.setType("heading_2");
        text2.setContent("test");
        blockText.setText(text2);
        textList.add(blockText);
//        blockProperty.setText(textList);
//        newBlockProperties.setHeading_2(blockProperty);
        list.add(newBlockProperties);
        newBlock.setChildren(list);

        var result = blockService.append("7095e394-93f1-4b5f-8ea6-37909568797f", newBlock);
        var text = jsonUtil.objectToJson(result);

        System.out.println(text);
    }

    @Test
    void appendJsonLoadTest() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource("json/block_append.json");

            BlockRequest blockRequest = objectMapper.readValue(resource.getFile(), BlockRequest.class);

            System.out.println(blockRequest);

            var result = blockService.append("7095e394-93f1-4b5f-8ea6-37909568797f", blockRequest);

            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}