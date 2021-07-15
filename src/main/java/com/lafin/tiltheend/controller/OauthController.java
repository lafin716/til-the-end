package com.lafin.tiltheend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/oauth")
public class OauthController {

    @GetMapping("/callback")
    public String callback(String jsonCallback) {
        return jsonCallback;
    }
}
