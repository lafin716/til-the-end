package com.lafin.tiltheend.util;

import com.lafin.tiltheend.thirdparty.notion.dto.DatabaseResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.PageResponse;
import com.lafin.tiltheend.thirdparty.notion.dto.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
public class RestTemplateUtil<REQ extends Request,RESP> {

    @Value("${notion.secret}")
    private String appSecret;

    public PageResponse getCall(String url, REQ parameters) {
        var uriComponentsBuilder = UriComponentsBuilder.fromUriString(url);

        if (!Objects.isNull(parameters)) {
            uriComponentsBuilder.queryParams(parameters.toQueryParameters());
        }

        var uri = uriComponentsBuilder.build().encode().toUri();

        var headers = new HttpHeaders();
        headers.set("Notion-Version", "2021-05-13");
        headers.set("Authorization", "Bearer " + appSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<PageResponse>(){};
        var responseEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, responseType);

        return responseEntity.getBody();
    }
}
