package com.lafin.tiltheend.thirdparty.github.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OAuthRequest implements Request {

    private String clientId;

    private String clientSecret;

    private String redirectUrl;

    private String code;

    private String scope;

    @Override
    public MultiValueMap toQueryParameters() {
        var map = new LinkedMultiValueMap<String, String>();
        if (clientId != null) map.add("client_id", clientId);
        if (clientSecret != null) map.add("client_secret", clientSecret);
        if (redirectUrl != null) map.add("redirect_url", redirectUrl);
        if (code != null) map.add("code", code);
        if (scope != null) map.add("scope", scope);

        return map;
    }
}
