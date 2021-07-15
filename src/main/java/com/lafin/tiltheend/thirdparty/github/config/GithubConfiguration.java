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
}
