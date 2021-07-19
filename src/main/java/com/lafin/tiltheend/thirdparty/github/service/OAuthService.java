package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.config.GithubApi;
import com.lafin.tiltheend.thirdparty.github.constant.AuthApi;
import com.lafin.tiltheend.thirdparty.github.dto.request.OAuthRequest;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OAuthService extends GithubService {

    @Resource(name = "clientId")
    private String clientId;

    @Resource(name = "clientSecret")
    private String clientSecret;

    @Resource(name = "redirectUrl")
    private String redirectUrl;

    public String getAuthorizeUrl() {
        OAuthRequest oAuthRequest = new OAuthRequest();
        oAuthRequest.setClientId(clientId);
        oAuthRequest.setClientSecret(clientSecret);
        oAuthRequest.setRedirectUrl(redirectUrl);
        oAuthRequest.setScope("user,public_repo");

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
        OAuthRequest oAuthRequest = new OAuthRequest();
        oAuthRequest.setClientId(clientId);
        oAuthRequest.setClientSecret(clientSecret);
        oAuthRequest.setCode(code);

        var result = (AccessTokenResponse) restTemplateBuilder.url(GithubApi.AUTH_URL)
                .method(HttpMethod.POST)
                .path(AuthApi.ACCESS_TOKEN)
                .contentType(defaultContentType)
                .headers(defaultHeaders())
                .request(oAuthRequest)
                .response(AccessTokenResponse.class)
                .build()
                .getBody();

        return result;
    }

    public String getAccessTokenUrl(String code) {
        OAuthRequest oAuthRequest = new OAuthRequest();
        oAuthRequest.setClientId(clientId);
        oAuthRequest.setClientSecret(clientSecret);
        oAuthRequest.setCode(code);

        var result = (String) restTemplateBuilder.url(GithubApi.AUTH_URL)
                .method(HttpMethod.POST)
                .path(AuthApi.ACCESS_TOKEN)
                .contentType(defaultContentType)
                .headers(defaultHeaders())
                .request(oAuthRequest)
                .response(String.class)
                .getUrl();

        return result;
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
