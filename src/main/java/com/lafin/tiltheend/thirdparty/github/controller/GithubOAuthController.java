package com.lafin.tiltheend.thirdparty.github.controller;

import com.lafin.tiltheend.thirdparty.github.GithubClient;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/github")
@RequiredArgsConstructor
public class GithubOAuthController {

    private final GithubClient githubClient;

    @GetMapping("/authorize")
    public String authorize() {
        return "redirect:" + githubClient.getOAuth().getAuthorizeUrl();
    }

    @GetMapping("/callback")
    public AccessTokenResponse callback(@RequestParam String code) {
        log.info("code : {}", code);
        return githubClient.getOAuth().getAccessToken(code);
    }
}
