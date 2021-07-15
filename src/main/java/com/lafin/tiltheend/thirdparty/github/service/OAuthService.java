package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.config.GithubApi;
import com.lafin.tiltheend.thirdparty.github.constant.AuthApi;
import com.lafin.tiltheend.thirdparty.github.dto.request.OAuthRequest;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuthService extends GithubService {

    private final OAuthRequest oAuthRequest;

    public String authorize() {
        String result = (String) restTemplateBuilder.url(GithubApi.AUTH_URL)
                .method(HttpMethod.GET)
                .path(AuthApi.AUTHORIZE)
                .contentType(defaultContentType)
                .request(oAuthRequest)
                .response(String.class)
                .build()
                .getUrl();

        return result;
    }

    public AccessTokenResponse getAccessToken(String code) {
        oAuthRequest.setCode(code);
        var result = (AccessTokenResponse) restTemplateBuilder.url(GithubApi.AUTH_URL)
                .method(HttpMethod.GET)
                .path(AuthApi.ACCESS_TOKEN)
                .contentType(defaultContentType)
                .headers(defaultHeaders())
                .request(oAuthRequest)
                .response(AccessTokenResponse.class)
                .build()
                .getBody();

        return result;
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
