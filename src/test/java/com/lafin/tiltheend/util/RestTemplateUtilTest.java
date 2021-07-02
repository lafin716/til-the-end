package com.lafin.tiltheend.util;

import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.dto.DatabaseRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.PageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestTemplateUtilTest {

    @Autowired
    private RestTemplateUtil restTemplateUtil;

    @Test
    void uriTest() {
        var uri = createDatabaseApiUri();
        System.out.println(uri);
    }

    @Test
    void callTest() {
        var result = restTemplateUtil.getCall(ApiConfig.API_URL + "/pages/851676d8c99042d4b46ed0c44334188a", null);

        System.out.println(result);
    }

    private URI createDatabaseApiUri() {
        var databaseRequest = new DatabaseRequest();
        var uri = UriComponentsBuilder.fromUriString(ApiConfig.API_URL + "/databases/851676d8c99042d4b46ed0c44334188a")
                .queryParams(databaseRequest.toQueryParameters())
                .build()
                .encode()
                .toUri();

        return uri;
    }
}