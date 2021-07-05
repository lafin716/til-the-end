package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.library.resttemplate.RestTemplateBuilder;
import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.constant.DatabaseApi;
import com.lafin.tiltheend.thirdparty.notion.dto.request.DatabaseRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.DatabaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService extends BaseService {

    /**
     * Retrieves a Database object using the ID specified.
     * @param databaseId
     */
    public DatabaseResponse retrieve(String databaseId) {
        return (DatabaseResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                                                .method(HttpMethod.GET)
                                                .path(DatabaseApi.RETRIEVE)
                                                .pathExpend(databaseId)
                                                .contentType(defaultContentType)
                                                .headers(defaultHeaders)
                                                .response(DatabaseResponse.class)
                                                .build()
                                                .getBody();
    }

    /**
     * Gets a list of Pages contained in the database,
     * filtered and ordered according to the filter conditions and sort criteria provided in the request.
     * The response may contain fewer than page_size of results.
     * @param databaseId
     */
    public DatabaseResponse query(String databaseId, DatabaseRequest databaseRequest) {
        return (DatabaseResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.POST)
                .path(DatabaseApi.QUERY)
                .pathExpend(databaseId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .request(databaseRequest)
                .response(DatabaseResponse.class)
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
}
