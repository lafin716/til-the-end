package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.library.resttemplate.RestTemplateBuilder;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OAuthServiceTest {

    @Autowired
    private OAuthService oAuthService;

    private String code = "";

    @Description("1. Authorize 호출하여 code값 생성 (웹에서 허용을 눌러야 하므로 URL만 노출)")
    @Test
    void authorizeTest() {
        code = oAuthService.getAuthorizeUrl();

        System.out.println(code);
    }

    @Test
    void getAccessTokenTest() {
        var authorizeUrl = oAuthService.getAuthorizeUrl();
        var restTemplate = new RestTemplateBuilder();
        var result = restTemplate.url(authorizeUrl)
                                                .response(AccessTokenResponse.class)
                                                .build();


        System.out.println(result);
    }
}