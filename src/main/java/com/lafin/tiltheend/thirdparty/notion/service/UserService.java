package com.lafin.tiltheend.thirdparty.notion.service;

import com.lafin.tiltheend.thirdparty.notion.config.ApiConfig;
import com.lafin.tiltheend.thirdparty.notion.constant.BlockApi;
import com.lafin.tiltheend.thirdparty.notion.constant.UserApi;
import com.lafin.tiltheend.thirdparty.notion.dto.request.UserRequest;
import com.lafin.tiltheend.thirdparty.notion.dto.response.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class UserService extends NotionService {

    /**
     * Retrieves a User using the ID specified.
     * @param userId
     */
    public UserResponse retrieve(String userId) {
        return (UserResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(UserApi.RETRIEVE)
                .pathExpend(userId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .response(UserResponse.class)
                .build()
                .getBody();
    }

    /**
     * Retrieves a User using the ID specified.
     * This will return raw type response
     * @param userId
     */
    public HashMap retrieveRaw(String userId) {
        return (HashMap) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(BlockApi.RETRIEVE)
                .pathExpend(userId)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .response(HashMap.class)
                .build()
                .getBody();
    }

    /**
     * Returns a paginated list of Users for the workspace. The response may contain fewer than page_size of results.
     * See Pagination for details about how to use a cursor to iterate through the list.
     * @param userRequest
     */
    public UserResponse list(UserRequest userRequest) {
        return (UserResponse) restTemplateBuilder.url(ApiConfig.API_URL)
                .method(HttpMethod.GET)
                .path(UserApi.LIST)
                .contentType(defaultContentType)
                .headers(defaultHeaders)
                .request(userRequest)
                .response(new ParameterizedTypeReference<Object>(){})
                .build()
                .getBody();
    }


    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
