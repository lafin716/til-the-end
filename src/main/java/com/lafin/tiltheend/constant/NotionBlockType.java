package com.lafin.tiltheend.constant;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Locale;

public enum NotionBlockType {
    HEADING_1,
    HEADING_2,
    HEADING_3,
    BULLETED_LIST_ITEM,
    CHILD_PAGE,
    TO_DO,
    TOGGLE,
    PARAGRAPH;

    @JsonCreator
    public static NotionBlockType from(String s) {
        return NotionBlockType.valueOf(s.toUpperCase());
    }
}
