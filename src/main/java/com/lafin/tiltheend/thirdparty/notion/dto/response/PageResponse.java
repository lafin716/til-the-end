package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Response;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PageResponse implements Response {

    private String url;
    private boolean archived;
    private Map<String, String> parent;
    private String lastEditedTime;
    private String createdTime;
    private String id;
    private String object;
    private Properties properties;

    @Data
    @NoArgsConstructor
    @ToString
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Properties {
        private Title title;

        @Data
        @NoArgsConstructor
        @ToString
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Title {
            private String id;
            private String type;

            @JsonProperty("title")
            private List<Titles> title;

            @Data
            @NoArgsConstructor
            @ToString
            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
            public static class Titles {
                private String type;
                private String plainText;
            }
        }
    }
}
