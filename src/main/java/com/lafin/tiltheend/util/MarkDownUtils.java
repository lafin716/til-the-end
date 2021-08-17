package com.lafin.tiltheend.util;

import com.lafin.tiltheend.constant.NotionBlockType;
import com.lafin.tiltheend.dto.BlockDto;

import java.util.HashMap;
import java.util.Map;

public class MarkDownUtils {

    public static Map<NotionBlockType, String> keywords = new HashMap<>(){
        {
            put(NotionBlockType.HEADING_1, "#");
            put(NotionBlockType.HEADING_2, "##");
            put(NotionBlockType.HEADING_3, "###");
            put(NotionBlockType.BULLETED_LIST_ITEM, "-");
            put(NotionBlockType.TOGGLE, ">");
            put(NotionBlockType.TO_DO, "[*]");
            put(NotionBlockType.CHILD_PAGE, "[%s](%s)");
            put(NotionBlockType.PARAGRAPH, "");
        }
    };

    public static String translate(BlockDto block) {
        StringBuilder result = new StringBuilder();

        // child_page 인 경우 링크 형식을 맞춰서 치환
        if (block.getType() == NotionBlockType.CHILD_PAGE) {
            result.append(String.format(keywords.get(block.getType()), block.getText(), block.getId()));
        } else {
            result.append(keywords.get(block.getType()));
            result.append(" ");
            result.append(block.getText());
        }

        return result.toString();
    }
}
