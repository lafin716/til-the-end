package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.library.resttemplate.RestTemplateBuilder;
import com.lafin.tiltheend.thirdparty.notion.config.NotionConfiguration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public abstract class BaseService {

    @Resource(name = "defaultHeaders")
    public Map<String, String> defaultHeaders;

    public RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();;

    public MediaType defaultContentType = MediaType.APPLICATION_JSON;
}
