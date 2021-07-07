package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.library.resttemplate.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public abstract class NotionService implements Supportable{

    @Resource(name = "defaultHeaders")
    public Map<String, String> defaultHeaders;

    public RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

    public MediaType defaultContentType = MediaType.APPLICATION_JSON;
//
//    public abstract Response retrieve(String id);
//
//    public abstract Response list(String startCursor, int pageSize);
//
//    public abstract Response create(String databaseId, DatabaseRequest databaseRequest);
//
//    public abstract Response update(String id);
//
//    public abstract Response append(String id);
//
//    public abstract Response search(String id);
}
