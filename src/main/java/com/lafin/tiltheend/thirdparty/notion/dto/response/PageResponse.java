package com.lafin.tiltheend.thirdparty.notion.dto.response;

import com.lafin.tiltheend.library.resttemplate.Response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PageResponse implements Response {

    private String url;
    private boolean archived;
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
        private String database_id;
        private String type;
    }
}
