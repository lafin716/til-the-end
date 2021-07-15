package com.lafin.tiltheend.thirdparty.github.connect;

import com.lafin.tiltheend.thirdparty.github.service.GithubService;
import com.lafin.tiltheend.thirdparty.notion.service.NotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GithubServiceProvider {

    @Autowired
    private List<GithubService> githubServices;

    public GithubService getService(Class<?> clazz) {
        return githubServices.stream()
                .filter(it -> it.support(clazz))
                .findFirst()
                .orElseThrow(() -> new NullPointerException());
    }
}
