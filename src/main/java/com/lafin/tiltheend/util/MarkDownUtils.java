package com.lafin.tiltheend.util;

import java.util.HashMap;
import java.util.Map;

public class MarkDownUtils {

    public static Map<String, String> keywords = new HashMap<>(){
        {
            put("heading_1", "#");
            put("heading_2", "##");
            put("heading_3", "###");
            put("bulleted_list_item", "-");
        }
    };

    public static String translate(String type, String text) {
        return "";
    }
}
