package com.lafin.tiltheend.thirdparty.github.dto.request;

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
public class OAuthRequest implements Request {

    @Resource(name = "clientId")
    private String clientId;

    @Resource(name = "clientSecret")
    private String clientSecret;

    @Resource(name = "redirectUrl")
    private String redirectUrl;

    private String code;

    @Override
    public MultiValueMap toQueryParameters() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("redirect_url", redirectUrl);
        map.add("code", code);

        return map;
    }
}
