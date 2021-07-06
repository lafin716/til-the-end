package com.lafin.tiltheend.thirdparty.notion.connect;

import com.lafin.tiltheend.thirdparty.notion.config.ApiType;
import com.lafin.tiltheend.thirdparty.notion.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotionServiceProvider {

    @Autowired
    private List<NotionService> notionServices;

    public NotionService getService(Class<?> clazz) {
        return notionServices.stream()
                .filter(it -> it.support(clazz))
                .findFirst()
                .orElseThrow(() -> new NullPointerException());
    }
}
