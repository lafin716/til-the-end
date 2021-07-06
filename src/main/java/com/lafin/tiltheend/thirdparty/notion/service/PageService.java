package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.config.ApiType;
import com.lafin.tiltheend.thirdparty.notion.constant.DatabaseApi;
import com.lafin.tiltheend.thirdparty.notion.constant.PageApi;
import com.lafin.tiltheend.thirdparty.notion.dto.request.DatabaseParent;
import com.lafin.tiltheend.thirdparty.notion.dto.request.DatabaseRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageParent;
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
    public PageResponse createFromDatabase(PageRequest<DatabaseParent> pageRequest) {
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
    public PageResponse createFromPage(PageRequest<PageParent> pageRequest) {
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
     * Updates page property values for the specified page. Properties that are not set via the properties parameter will remain unchanged.
     * If the parent is a database, the new property values in the properties parameter must conform to the parent database's property schema.
     * Returns a 200 HTTP response containing the updated page object on success.
     * Requests and responses contains page properties, not page content. To fetch page content, use the retrieve block children endpoint. To append page content, use the append block children endpoint.
     * @param pageId
     * @param pageRequest
     */
    public PageResponse update(String pageId, PageRequest pageRequest) {
        return (PageResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(PageApi.UPDATE)
                .pathExpend(pageId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .request(pageRequest)
                .response(PageResponse.class)
                .build()
                .getBody();
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
