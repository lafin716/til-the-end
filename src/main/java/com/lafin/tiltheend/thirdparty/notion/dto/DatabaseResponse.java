package com.lafin.tiltheend.thirdparty.notion.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DatabaseResponse {

    private List<Database> results;
    private String nextCursor;
    private boolean hasMore;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class Database {
        private String object;
        private String id;
        private List<Parent> parent;
        private String title;
        private List<Properties> properties;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        private static class Parent {
            private String type;
            private String pageId;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @ToString
        private static class Properties {
            @JsonProperty(namespace = "Name")
            private String name;
            @JsonProperty(namespace = "Description")
            private String description;
        }
    }


}
