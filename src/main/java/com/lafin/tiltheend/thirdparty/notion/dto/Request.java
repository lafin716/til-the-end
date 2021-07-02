package com.lafin.tiltheend.thirdparty.notion.dto;

import org.springframework.util.MultiValueMap;

public interface Request {
    MultiValueMap toQueryParameters();
}
