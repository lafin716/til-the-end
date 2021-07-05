package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.lafin.tiltheend.library.resttemplate.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DatabaseResponse implements Response {

    private Parent parent;
    private String last_edited_time;
    private String created_time;
    private String id;
    private String object;

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Parent {
        private String page_id;
        private String type;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @ToString
    public static class Title {

        private String plain_text;
        private Annotations annotations;
        private Text text;
        private String type;

        @Getter
        @Setter
        @NoArgsConstructor
        @ToString
        public static class Annotations {
            private String color;
            private boolean code;
            private boolean underline;
            private boolean strikethrough;
            private boolean italic;
            private boolean bold;

        }

        @Getter
        @Setter
        @NoArgsConstructor
        @ToString
        public static class Text {
            private String content;
        }
    }
}
