package com.lafin.tiltheend.thirdparty.notion.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.*;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlockRequest implements Request {

    private String object;

    private String id;

    private String type;

    private String createdTime;

    private String lastEditedTime;

    private boolean hasChildren;

    private Map<String, Object> paragraph;

    private Map<String, Object> heading_1;

    private Map<String, Object> heading_2;

    private Map<String, Object> heading_3;

    private Map<String, Object> bulleted_list_item;

    private Map<String, Object> numbered_list_item;

    private Map<String, Object> to_do;

    private Map<String, Object> toggle;

    private Map<String, Object> child_page;

    private Map<String, Object> unsupported;

    @Override
    public MultiValueMap toQueryParameters() {
        return null;
    }
}
