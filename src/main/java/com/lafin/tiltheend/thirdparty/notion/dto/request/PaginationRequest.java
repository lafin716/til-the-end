package com.lafin.tiltheend.thirdparty.notion.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaginationRequest implements Request {

    protected String startCursor;

    protected int pageSize;

    @Override
    public MultiValueMap toQueryParameters() {
        return new LinkedMultiValueMap(){
            {
                add("start_cursor", startCursor);
                add("page_size", String.valueOf(pageSize));
            }
        };
    }
}
