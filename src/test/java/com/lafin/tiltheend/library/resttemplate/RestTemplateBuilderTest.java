package com.lafin.tiltheend.library.resttemplate;

import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.dto.request.PageRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.PageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;

@SpringBootTest
class RestTemplateBuilderTest {

    @Value("${notion.api_token}")
    private String appSecret;

    @Value("${notion.version}")
    private String version;

    @Test
    public void getTest() {
        var pageId = "851676d8c99042d4b46ed0c44334188a";
        var url = ApiConfig.API_URL;
        var path = "/pages/{pageId}";
        var pathExpend = pageId;

        var headers = new HashMap<String, String>();
        headers.put("Notion-Version", version);
        headers.put("Authorization", "Bearer " + appSecret);
        headers.forEach((key, val) -> System.out.println("key : " + key + " : vale : " + val));

        System.out.println("url >> " + String.format(url + path, pageId));

        var result = new RestTemplateBuilder()
                .url(url)
                .method(HttpMethod.GET)
                .path(path)
                .pathExpend(pathExpend)
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .response(PageResponse.class)
                .build();

        System.out.println(result.getBody());
    }

    @Test
    void uriTest() {
        var pageId = "851676d8c99042d4b46ed0c44334188a";
        var url = ApiConfig.API_URL;
        var path = "/pages/{pageId}";
        var pathExpend = pageId;

        var uri = UriComponentsBuilder.fromUriString(url)
                .path(path)
                .queryParams(null)
                .encode()
                .build()
                .expand(pathExpend)
                .toUri();

        System.out.println("uri >>> " + uri);
    }

    @Test
    void getRequestRaw() {
        var pageId = "851676d8c99042d4b46ed0c44334188a";
        var url = ApiConfig.API_URL;
        var path = "/pages/{pageId}";
        var pathExpend = pageId;

        var headers = new HashMap<String, String>();
        headers.put("Notion-Version", version);
        headers.put("Authorization", "Bearer " + appSecret);
        headers.forEach((key, val) -> System.out.println("key : " + key + " : vale : " + val));

        System.out.println("url >> " + String.format(url + path, pageId));

        var uri = UriComponentsBuilder.fromUriString(url)
                .path(path)
                .encode()
                .build()
                .expand(pathExpend)
                .toUri();

        System.out.println(uri);

//        var entity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, PageResponse.class)

//        System.out.println(entity);
    }
}