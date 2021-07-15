package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.config.GithubApi;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitFileRequest;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitPathRequest;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService extends GithubService {

    public String commit(AccessTokenResponse accessToken, CommitPathRequest commitPathRequest, CommitFileRequest commitFileRequest) {
        return (String) restTemplateBuilder.url(GithubApi.API_URL)
                .method(HttpMethod.PUT)
                .pathExpend(
                        commitPathRequest.getOwner(),
                        commitPathRequest.getRepo(),
                        commitPathRequest.getPath())
                .contentType(defaultContentType)
                .headers(getTokenHeaders(accessToken))
                .request(commitFileRequest)
                .response(String.class)
                .build()
                .getBody();
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
