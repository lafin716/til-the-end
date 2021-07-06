package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.config.ApiType;
import com.lafin.tiltheend.thirdparty.notion.constant.DatabaseApi;
import com.lafin.tiltheend.thirdparty.notion.constant.PageApi;
import com.lafin.tiltheend.thirdparty.notion.dto.request.DatabaseRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.DatabaseResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class PageService extends NotionService {

    /**
     * Retrieves a Page object using the ID specified.
     * @param pageId
     */
    public PageResponse retrieve(String pageId) {
        return (PageResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(PageApi.RETRIEVE)
                .pathExpend(pageId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .response(PageResponse.class)
                .build()
                .getBody();
    }

    /**
     * Retrieves a Page object using the ID specified.
     * @param pageId
     */
    public HashMap retrieveRaw(String pageId) {
        return (HashMap) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(PageApi.RETRIEVE)
                .pathExpend(pageId)
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
     * @param pageRequest
     */
    public PageResponse createFromDatabase(PageRequest pageRequest) {
        return (PageResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.POST)
                .path(PageApi.CREATE)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .request(pageRequest)
                .response(PageResponse.class)
                .build()
                .getBody();
    }

    /**
     * Gets a list of Pages contained in the database,
     * filtered and ordered according to the filter conditions and sort criteria provided in the request.
     * The response may contain fewer than page_size of results.
     * @param pageRequest
     */
    public PageResponse createFromPage(PageRequest pageRequest) {
        return (PageResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.POST)
                .path(PageApi.CREATE)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .request(pageRequest)
                .response(PageResponse.class)
                .build()
                .getBody();
    }

    /**
     * Listing the notion databases
     * ! This endpoint is no longer recommended, use `search` instead.
     * ! This endpoint will only return explicitly shared pages.
     * @param startCursor
     * @param pageSize
     */
    public DatabaseResponse list(String startCursor, int pageSize) {
        return (DatabaseResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(DatabaseApi.LIST)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .query("start_cursor", startCursor)
                .query("page_size", String.valueOf(pageSize))
                .response(DatabaseResponse.class)
                .build()
                .getBody();
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
