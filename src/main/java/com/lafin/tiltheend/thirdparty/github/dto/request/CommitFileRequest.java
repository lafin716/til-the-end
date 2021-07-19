package com.lafin.tiltheend.thirdparty.github.dto.request;

import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CommitFileRequest implements Request {

    private String message;

    private String content;

    private String sha;

    private String branch;

    private Committer committer;

    private Author author;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class Committer {

        private String name;

        private String email;

        private String date;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    @EqualsAndHashCode
    public static class Author {

        private String name;

        private String email;

        private String date;

    }

    @Override
    public MultiValueMap toQueryParameters() {
        return new LinkedMultiValueMap(){
            {
                add("message", message);
                add("content", content);
                add("sha", sha);
                add("branch", branch);
                add("committer", committer);
                add("author", author);
            }
        };
    }
}
