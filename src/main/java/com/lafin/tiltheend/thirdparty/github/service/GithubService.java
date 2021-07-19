package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.library.resttemplate.RestTemplateBuilder;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public abstract class GithubService implements Supportable {

    public RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    public MediaType defaultContentType = MediaType.APPLICATION_JSON;

    public String defaultAccept = "application/vnd.github.v3+json";

    public Map<String, String> defaultHeaders() {
        return new HashMap<>(){
            {
                put("accept", defaultAccept);
            }
        };
    }

    public Map<String, String> getTokenHeader(String accessToken) {
        var headers = defaultHeaders();
        headers.put("Authorization", "token " + accessToken);

        return headers;
    }

    public Map<String, String> getTokenHeaders(AccessTokenResponse accessToken) {
        var headers = defaultHeaders();
        headers.put("Authorization", "token " + accessToken.getAccessToken());

        return headers;
    }
}
