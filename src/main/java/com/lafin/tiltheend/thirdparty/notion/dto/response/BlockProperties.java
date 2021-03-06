package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BlockProperties {

    private List<RichTextResponse> text;

    @Data
    @NoArgsConstructor
    @ToString
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Properties {

        private String type;

        private Text text;

        private Annotations annotations;

        private String plainText;

        private String href;

        @Data
        @NoArgsConstructor
        @ToString
        @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Text {

            private String content;

            private LinkResponse link;

        }

    }
}
