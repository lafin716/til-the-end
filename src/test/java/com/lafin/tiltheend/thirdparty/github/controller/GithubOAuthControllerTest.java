package com.lafin.tiltheend.thirdparty.github.controller;

import com.lafin.tiltheend.library.resttemplate.RestTemplateBuilder;
import com.lafin.tiltheend.thirdparty.github.GithubClient;
import com.lafin.tiltheend.thirdparty.github.config.GithubApi;
import com.lafin.tiltheend.thirdparty.github.constant.AuthApi;
import com.lafin.tiltheend.thirdparty.github.dto.request.OAuthRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GithubOAuthController.class)
class GithubOAuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GithubClient githubClient;

    @Test
    void getAccessTokenTest() throws Exception {
        var client_id = "30061f4f421898afcf97";
        var client_secret = "a719a548c1382210c0372d7b30a9ff69e90a19cf";
        var redirect_url = "http://localhost:8080/api/github/callback";

        OAuthRequest oAuthRequest = new OAuthRequest();
        oAuthRequest.setClientId(client_id);
        oAuthRequest.setClientSecret(client_secret);
        oAuthRequest.setRedirectUrl(redirect_url);

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        var url = restTemplateBuilder.url(GithubApi.AUTH_URL)
                .method(HttpMethod.GET)
                .path(AuthApi.AUTHORIZE)
                .contentType(MediaType.APPLICATION_JSON)
                .request(oAuthRequest)
                .response(String.class)
                .build()
                .getUrl();
        System.out.println("url : " + url);

        mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}