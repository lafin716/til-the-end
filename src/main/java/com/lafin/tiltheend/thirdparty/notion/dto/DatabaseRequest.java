package com.lafin.tiltheend.thirdparty.notion.dto;


import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DatabaseRequest implements Request{
    private String startCursor = "";
    private int pageSize;

    @Override
    public MultiValueMap<String, String> toQueryParameters() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("start_cursor", startCursor);
        map.add("page_size", String.valueOf(pageSize));

        return map;
    }
}
