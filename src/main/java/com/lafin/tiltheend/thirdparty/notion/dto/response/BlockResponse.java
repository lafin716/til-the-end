package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Response;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlockResponse implements Response {

    private String object;

    private String id;

    private String type;

    private String createdTime;

    private String lastEditedTime;

    private boolean hasChildren;

//    @JsonProperty("paragraph")
//    private BlockProperties paragraph;
//
//    @JsonProperty("heading_1")
//    private BlockProperties heading_1;
//
//    @JsonProperty("heading_2")
//    private BlockProperties heading_2;
//
//    @JsonProperty("heading_3")
//    private BlockProperties heading_3;
//
//    @JsonProperty("bulleted_list_item")
//    private BlockProperties bulleted_list_item;
//
//    @JsonProperty("numbered_list_item")
//    private BlockProperties numbered_list_item;
//
//    @JsonProperty("to_do")
//    private BlockProperties to_do;
//
//    @JsonProperty("toggle")
//    private BlockProperties toggle;

    @JsonAlias({ "paragraph", "heading_1", "heading_2", "heading_3", "bulleted_list_item", "numbered_list_item", "to_do", "toggle" })
    private BlockProperties child;

    @JsonProperty("child_page")
    private BlockProperties child_page;

    @JsonProperty("unsupported")
    private BlockProperties unsupported;

}
