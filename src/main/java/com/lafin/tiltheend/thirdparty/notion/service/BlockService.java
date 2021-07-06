package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.constant.BlockApi;
import com.lafin.tiltheend.thirdparty.notion.constant.DatabaseApi;
import com.lafin.tiltheend.thirdparty.notion.constant.PageApi;
import com.lafin.tiltheend.thirdparty.notion.dto.request.BlockRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.response.DatabaseResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class BlockService extends NotionService {

    /**
     * Retrieves a Page object using the ID specified.
     * @param blockId
     */
    public BlockResponse retrieve(String blockId) {
        return (BlockResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(BlockApi.RETRIEVE)
                .pathExpend(blockId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .response(BlockResponse.class)
                .build()
                .getBody();
    }

    /**
     * Retrieves a Page object using the ID specified.
     * @param blockId
     */
    public HashMap retrieveRaw(String blockId) {
        return (HashMap) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(BlockApi.RETRIEVE)
                .pathExpend(blockId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .response(HashMap.class)
                .build()
                .getBody();
    }

    /**
     * Gets a list of Pages contained in the database,
     * filtered and ordered according to the filter conditions and sort criteria provided in the request.
     * The response may contain fewer than page_size of results.
     * @param blockRequest
     */
    public BlockResponse append(String blockId, BlockRequest blockRequest) {
        return (BlockResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.POST)
                .path(BlockApi.APPEND)
                .pathExpend(blockId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .request(blockRequest)
                .response(BlockResponse.class)
                .build()
                .getBody();
    }


    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
