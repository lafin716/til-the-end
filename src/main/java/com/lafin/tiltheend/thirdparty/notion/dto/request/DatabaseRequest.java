package com.lafin.tiltheend.thirdparty.notion.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DatabaseRequest extends PaginationRequest implements Request {

    private Filter filter;

    private Sort sort;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Filter {

        private String property;

        private Map<String, Object> filter;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Sort {

        private String property;

        private TimeStamp timestamp;

        private Direction direction;

        public enum TimeStamp {
            CREATED_TIME,
            LAST_EDITED_TIME
        }

        public enum Direction {
            ASCENDING,
            DESCENDING
        }
    }

    @Override
    public MultiValueMap<String, String> toQueryParameters() {
        return null;
    }
}
