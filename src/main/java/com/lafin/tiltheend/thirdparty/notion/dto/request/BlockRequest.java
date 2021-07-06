package com.lafin.tiltheend.thirdparty.notion.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import com.lafin.tiltheend.thirdparty.notion.dto.response.BlockResponse;
import lombok.*;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BlockRequest extends PaginationRequest implements Request {

    private List<BlockResponse> children;

    @Override
    public MultiValueMap toQueryParameters() {
        return null;
    }
}
