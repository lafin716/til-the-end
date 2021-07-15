package com.lafin.tiltheend.thirdparty.github.dto.response;

import com.lafin.tiltheend.library.resttemplate.Response;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccessTokenResponse implements Response {

    private String accessToken;

    private String scope;

    private String tokenType;
}

