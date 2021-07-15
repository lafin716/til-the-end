package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.dto.request.CommitFileRequest;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitPathRequest;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryServiceTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void commitTest() {
        AccessTokenResponse accessTokenResponse = new AccessTokenResponse();
        accessTokenResponse.setAccessToken("");

        CommitPathRequest commitPathRequest = new CommitPathRequest();
        commitPathRequest.setOwner("lafin716");
        commitPathRequest.setRepo("knowledge_bank");
        commitPathRequest.setPath("src/com/lafin/knowledge/til/2021");

        CommitFileRequest commitFileRequest = new CommitFileRequest();
        commitFileRequest.setBranch("develop");
        commitFileRequest.setMessage("docs: TIL 추가 테스트 by API");
        commitFileRequest.setContent("test api taemi");

        var result = repositoryService.commit(accessTokenResponse, commitPathRequest, commitFileRequest);

        System.out.println(result);
    }


}