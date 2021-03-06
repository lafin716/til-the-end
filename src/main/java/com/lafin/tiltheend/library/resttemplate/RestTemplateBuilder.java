package com.lafin.tiltheend.library.resttemplate;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RestTemplateBuilder {

    private String url;

    private HttpMethod method = HttpMethod.GET;

    private Request request;

    private Map<String, String> query;

    private URI uri;

    private String path;

    private Object[] pathExpend;

    private HttpHeaders headers;

    private RequestEntity<?> requestEntity;

    private Class<?> response;

    private ParameterizedTypeReference<?> genericResponse;

    private ResponseEntity<?> responseEntity;

    public RestTemplateBuilder url(String url) {
        this.url = url;
        return this;
    }

    public RestTemplateBuilder path(String path) {
        this.path = path;
        return this;
    }

    public RestTemplateBuilder pathExpend(Object... pathExpend) {
        this.pathExpend = pathExpend;
        return this;
    }

    public RestTemplateBuilder headers(Map<String, String> headers) {
        checkHttpHeader();

        headers.forEach((key, value) -> {
            this.headers.set(key, value);
        });
        return this;
    }

    public RestTemplateBuilder contentType(MediaType contentType) {
        checkHttpHeader();

        this.headers.setContentType(contentType);
        return this;
    }

    public RestTemplateBuilder method(HttpMethod method) {
        this.method = method;
        return this;
    }

    public RestTemplateBuilder request(Request request) {
        this.request = request;
        return this;
    }

    public RestTemplateBuilder query(String key, String value) {
        if (query == null) {
            query = new HashMap<>();
        }

        query.put(key, value);

        return this;
    }

    public RestTemplateBuilder response(Class<?> response) {
        this.response = response;
        return this;
    }

    public RestTemplateBuilder response(ParameterizedTypeReference<?> response) {
        this.genericResponse = response;
        return this;
    }

    public RestTemplateBuilder build() {
        createResponseEntity();

        return this;
    }

    public String getUrl() {
        return this.uri.toString();
    }

    public ResponseEntity<?> getResponseEntity() {
        return this.responseEntity;
    }

    public Object getBody() {
        return this.responseEntity.getBody();
    }

    private void createResponseEntity() {

        if (method == HttpMethod.GET) {
            createRequestForGet();
        } else if (method == HttpMethod.POST) {
            createRequestForPost();
        } else if (method == HttpMethod.PUT) {
            createRequestForPut();
        } else if (method == HttpMethod.DELETE) {
            createRequestForDelete();
        } else if (method == HttpMethod.PATCH) {
            createRequestForPatch();
        } else {
            return;
        }

        this.responseEntity = execute();
    }

    private void createRequestForGet() {
        var uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .path(path);

        if (request != null) {
            uriComponentsBuilder.queryParams(request.toQueryParameters());
        }

        var uriComponents = uriComponentsBuilder.encode().build();
        if (!ObjectUtils.isEmpty(pathExpend)) {
            uriComponents = uriComponents.expand(pathExpend);
        }

        this.uri = uriComponents.toUri();
        this.requestEntity = RequestEntity.get(uri)
                .headers(headers)
                .build();
    }

    private void createRequestForPost() {
        var uriComponentsBuilder = UriComponentsBuilder.fromUriString(url)
                .path(path)
                .encode()
                .build();

        if (Objects.nonNull(pathExpend)) {
            uriComponentsBuilder.expand(pathExpend);
        }

        this.uri = uriComponentsBuilder.toUri();

        this.requestEntity = RequestEntity.post(uri)
                .headers(headers)
                .body(request);
    }

    private void createRequestForPut() {
        this.uri = UriComponentsBuilder.fromUriString(url)
                .path(path)
                .encode()
                .build()
                .expand(pathExpend)
                .toUri();

        this.requestEntity = RequestEntity.put(uri)
                .headers(headers)
                .body(request);
    }

    private void createRequestForDelete() {
        this.uri = UriComponentsBuilder.fromUriString(url)
                .path(path)
                .encode()
                .build()
                .expand(pathExpend)
                .toUri();

        this.requestEntity = RequestEntity.delete(uri)
                .headers(headers)
                .build();
    }

    private void createRequestForPatch() {
        this.uri = UriComponentsBuilder.fromUriString(url)
                .path(path)
                .encode()
                .build()
                .expand(pathExpend)
                .toUri();

        this.requestEntity = RequestEntity.patch(uri)
                .headers(headers)
                .body(request);
    }

    private ResponseEntity<?> execute() {

        if (Objects.nonNull(genericResponse)) {
            return new RestTemplate(new HttpComponentsClientHttpRequestFactory()).exchange(uri, method, requestEntity, genericResponse);
        }

        return new RestTemplate(new HttpComponentsClientHttpRequestFactory()).exchange(uri, method, requestEntity, response);
    }

    private void checkHttpHeader() {
        if (Objects.isNull(this.headers)) {
            this.headers = new HttpHeaders();
        }
    }
}
