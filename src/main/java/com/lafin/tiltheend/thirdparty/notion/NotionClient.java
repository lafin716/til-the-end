package com.lafin.tiltheend.thirdparty.notion;

import com.lafin.tiltheend.thirdparty.notion.config.ApiType;
import com.lafin.tiltheend.thirdparty.notion.connect.NotionServiceProvider;
import com.lafin.tiltheend.thirdparty.notion.service.BlockService;
import com.lafin.tiltheend.thirdparty.notion.service.DatabaseService;
import com.lafin.tiltheend.thirdparty.notion.service.NotionService;
import com.lafin.tiltheend.thirdparty.notion.service.PageService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Notion API Client
 */
@Component
public class NotionClient {

    @Autowired
    private NotionServiceProvider notionServiceProvider;

    private NotionService getService(Class<?> clazz) {
        return notionServiceProvider.getService(clazz);
    }

    public PageService getPage() {
        return (PageService) getService(PageService.class);
    }

    public PageService getDatabase() {
        return (PageService) getService(DatabaseService.class);
    }

    public BlockService getBlock() {
        return (BlockService) getService(BlockService.class);
    }

    public PageService getUser() {
        return (PageService) getService(PageService.class);
    }
}
