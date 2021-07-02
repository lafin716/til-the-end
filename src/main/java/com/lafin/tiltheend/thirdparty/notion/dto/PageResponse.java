package com.lafin.tiltheend.thirdparty.notion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResponse {

    private String object;
    private String id;
    private LocalDateTime createdTime;
    private LocalDateTime lastEditedTime;
    private boolean archived;
    private String url;
    private Parent parent;
    private Properties properties;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Parent {
        private String type;
        private String databaseId;
    }

    @Data
    @NoArgsConstructor
    @ToString
    public static class Properties {

        @Data
        @NoArgsConstructor
        @ToString
        public static class Titles {
            private String id;
            private String type;
            private List<Title> title;

            @Data
            @NoArgsConstructor
            @ToString
            public static class Title {
                private String type;
                private Text text;
                private String plainText;
                private String href;

                @Data
                @NoArgsConstructor
                @ToString
                public static class Text {
                    private String content;
                    private String link;
                }
            }
        }
    }
}
