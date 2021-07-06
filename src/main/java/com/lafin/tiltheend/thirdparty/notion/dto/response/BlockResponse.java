package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Response;
import com.lafin.tiltheend.thirdparty.notion.dto.request.Parent;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlockResponse<P extends Parent> implements Response {

    private String object;
    private String id;
    private String type;
    private String createdTime;
    private String lastEditedTime;
    private boolean hasChildren;



}
