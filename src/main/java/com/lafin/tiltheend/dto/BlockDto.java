package com.lafin.tiltheend.dto;


import com.lafin.tiltheend.constant.NotionBlockType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlockDto {

    private String id;

    private NotionBlockType type = NotionBlockType.PARAGRAPH;

    private String text = "";

    private String url = "";

}
