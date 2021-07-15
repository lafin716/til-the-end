package com.lafin.tiltheend.thirdparty.github;

import com.lafin.tiltheend.thirdparty.github.connect.GithubServiceProvider;
import com.lafin.tiltheend.thirdparty.github.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Github API Client
 */
@Component
public class GithubClient {

    @Autowired
    private GithubServiceProvider githubServiceProvider;

    public OAuthService getOAuth() {
        return (OAuthService) githubServiceProvider.getService(OAuthService.class);
    }
}
