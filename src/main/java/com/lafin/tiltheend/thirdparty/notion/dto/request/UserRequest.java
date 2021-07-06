package com.lafin.tiltheend.thirdparty.notion.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest implements Request {

    private String startCursor;

    private int pageSize;

    @Override
    public MultiValueMap toQueryParameters() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.add("start_cursor", startCursor);
        map.add("page_size", String.valueOf(pageSize));

        return map;
    }
}
