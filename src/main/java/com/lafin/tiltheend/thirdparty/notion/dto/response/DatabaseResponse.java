package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Response;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class DatabaseResponse implements Response {

    private Parent parent;
    private String last_edited_time;
    private String created_time;
    private String id;
    private String object;

    @Data
    @NoArgsConstructor
    @ToString
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Parent {
        private String page_id;
        private String type;
    }

    @Data
    @NoArgsConstructor
    @ToString
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Title {

        private String plain_text;
        private Annotations annotations;
        private Text text;
        private String type;

        @Data
        @NoArgsConstructor
        @ToString
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Annotations {
            private String color;
            private boolean code;
            private boolean underline;
            private boolean strikethrough;
            private boolean italic;
            private boolean bold;

        }

        @Data
        @NoArgsConstructor
        @ToString
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Text {
            private String content;
        }
    }
}
