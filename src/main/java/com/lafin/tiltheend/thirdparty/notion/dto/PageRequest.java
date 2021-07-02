package com.lafin.tiltheend.thirdparty.notion.dto;

import org.springframework.util.MultiValueMap;

public class PageRequest implements Request{
    @Override
    public MultiValueMap toQueryParameters() {
        return null;
    }
}
