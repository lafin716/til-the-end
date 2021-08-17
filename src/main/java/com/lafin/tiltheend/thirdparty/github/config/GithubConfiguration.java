package com.lafin.tiltheend.thirdparty.github.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class GithubConfiguration {

    @Value("${github.client_id}")
    public String clientId;

    @Value("${github.client_secret}")
    public String clientSecret;

    @Value("${github.redirect_url}")
    public String redirectUrl;

    @Value("${github.api_token}")
    public String personalAccessToken;

    @Value("${github.name}")
    public String githubName;

    @Value("${github.email}")
    public String githubEmail;

    @Value("${github.owner}")
    public String owner;

    @Value("${github.repo}")
    public String repo;

    @Value("${github.path_prefix}")
    public String pathPrefix;

    @Value("${github.branch}")
    public String branch;

    @Bean(name = "clientId")
    public String getClientId() {
        return clientId;
    }

    @Bean(name = "clientSecret")
    public String getClientSecret() {
        return clientSecret;
    }

    @Bean(name = "redirectUrl")
    public String getRedirectUrl() {
        return redirectUrl;
    }

    @Bean(name = "personalAccessToken")
    public String getPersonalAccessToken() { return personalAccessToken; }

    @Bean(name = "githubName")
    public String getGithubName() { return githubName; }

    @Bean(name = "githubEmail")
    public String getGithubEmail() { return githubEmail; }

    @Bean(name = "owner")
    public String getOwner() { return owner; }

    @Bean(name = "repo")
    public String getRepo() { return repo; }

    @Bean(name = "pathPrefix")
    public String getPathPrefix() { return pathPrefix; }

    @Bean(name = "branch")
    public String getBranch() { return branch; }

}
