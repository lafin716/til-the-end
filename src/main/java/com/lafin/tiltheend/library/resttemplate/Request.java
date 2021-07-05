package com.lafin.tiltheend.library.resttemplate;

import org.springframework.util.MultiValueMap;

public interface Request {
    MultiValueMap toQueryParameters();
}
