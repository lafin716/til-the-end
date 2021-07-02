package com.lafin.tiltheend.thirdparty.notion.connect;

import org.springframework.beans.factory.annotation.Value;

public class NotionServiceProvider {

    @Value("${notion.app_token}")
    private String appToken;


}
