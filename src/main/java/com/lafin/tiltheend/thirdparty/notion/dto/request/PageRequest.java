package com.lafin.tiltheend.thirdparty.notion.dto.request;

import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PageRequest implements Request {

    private String pageId;

    @Override
    public MultiValueMap toQueryParameters() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("page_id", pageId);

        return map;
    }
}
