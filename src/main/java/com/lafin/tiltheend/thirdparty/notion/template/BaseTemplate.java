package com.lafin.tiltheend.thirdparty.notion.template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseTemplate {

    @Value("${notion.app_token}")
    private String appToken;


}
