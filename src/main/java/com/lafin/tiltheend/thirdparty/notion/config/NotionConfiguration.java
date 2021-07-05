package com.lafin.tiltheend.thirdparty.notion.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class NotionConfiguration {

    @Value("${notion.api_token}")
    public String apiToken;

    @Value("${notion.version}")
    public String version;

    @Bean
    public Map<String, String> defaultHeaders() {
        return new HashMap<>(){
            {
                put("Notion-Version", version);
                put("Authorization", "Bearer " + apiToken);
            }
        };
    }

}
