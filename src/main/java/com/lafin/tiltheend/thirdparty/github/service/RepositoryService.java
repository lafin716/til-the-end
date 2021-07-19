package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.config.GithubApi;
import com.lafin.tiltheend.thirdparty.github.constant.RepoApi;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitFileRequest;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitPathRequest;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RepositoryService extends GithubService {

    @Resource(name = "personalAccessToken")
    private String personalAccessToken;

    public String commit(CommitPathRequest commitPathRequest, CommitFileRequest commitFileRequest) {
        return (String) restTemplateBuilder.url(GithubApi.API_URL)
                .method(HttpMethod.PUT)
                .path(RepoApi.UPLOAD_FILE)
                .pathExpend(
                        commitPathRequest.getOwner(),
                        commitPathRequest.getRepo(),
                        commitPathRequest.getPath())
                .contentType(defaultContentType)
                .headers(getTokenHeader(personalAccessToken))
                .request(commitFileRequest)
                .response(String.class)
                .build()
                .getBody();
    }

    public String commit(AccessTokenResponse accessToken, CommitPathRequest commitPathRequest, CommitFileRequest commitFileRequest) {
        return (String) restTemplateBuilder.url(GithubApi.API_URL)
                .method(HttpMethod.PUT)
                .path(RepoApi.UPLOAD_FILE)
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

    public String commitUrl(AccessTokenResponse accessToken, CommitPathRequest commitPathRequest, CommitFileRequest commitFileRequest) {
        return (String) restTemplateBuilder.url(GithubApi.API_URL)
                .method(HttpMethod.PUT)
                .path(RepoApi.UPLOAD_FILE)
                .pathExpend(
                        commitPathRequest.getOwner(),
                        commitPathRequest.getRepo(),
                        commitPathRequest.getPath())
                .contentType(defaultContentType)
                .headers(getTokenHeaders(accessToken))
                .request(commitFileRequest)
                .response(String.class)
                .build()
                .getUrl();
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
