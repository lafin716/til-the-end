package com.lafin.tiltheend.thirdparty.github.dto.request;

import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.*;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CommitPathRequest implements Request {

    private String owner;

    private String repo;

    private String path;

    @Override
    public MultiValueMap toQueryParameters() {
        return null;
    }
}
