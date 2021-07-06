package com.lafin.tiltheend.thirdparty.notion.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PageRequest implements Request {

    private DatabaseParent parent;
    
    private Map<String, Object> properties;

    private List<BlockRequest> children;

    @Override
    public MultiValueMap toQueryParameters() {
        var map = new LinkedMultiValueMap<String, String>();

        return map;
    }
}
