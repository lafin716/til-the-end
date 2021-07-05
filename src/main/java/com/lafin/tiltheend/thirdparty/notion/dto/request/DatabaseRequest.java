package com.lafin.tiltheend.thirdparty.notion.dto.request;


import com.lafin.tiltheend.library.resttemplate.Request;
import lombok.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class DatabaseRequest implements Request {
    private String startCursor = "";
    private int pageSize;
    private Filter filter;
    private Sort sort;

    public static class Filter {
        private String property;
        private Map<String, Object> filter;
    }

    public static class Sort {
        private String property;
        private TimeStamp timestamp;
        private Direction direction;

        public enum TimeStamp {
            CREATED_TIME,
            LAST_EDITED_TIME
        }

        public enum Direction {
            ASCENDING,
            DESCENDING
        }
    }

    @Override
    public MultiValueMap<String, String> toQueryParameters() {
        var map = new LinkedMultiValueMap<String, String>();
        map.add("start_cursor", startCursor);
        map.add("page_size", String.valueOf(pageSize));

        return map;
    }
}
