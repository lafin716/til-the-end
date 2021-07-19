package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.dto.request.CommitFileRequest;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitPathRequest;
import com.lafin.tiltheend.thirdparty.github.dto.response.AccessTokenResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Base64Utils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepositoryServiceTest {

    @Autowired
    private RepositoryService repositoryService;

    @Test
    void commitTest() {
        CommitPathRequest commitPathRequest = new CommitPathRequest();
        commitPathRequest.setOwner("lafin716");
        commitPathRequest.setRepo("knowledge_bank");
        commitPathRequest.setPath("src/com/lafin/knowledge/til/2021/0719.md");

        CommitFileRequest commitFileRequest = new CommitFileRequest();
        CommitFileRequest.Author author = new CommitFileRequest.Author();
        author.setName("lafin716");
        author.setEmail("lafin716@gmail.com");

        CommitFileRequest.Committer committer = new CommitFileRequest.Committer();
        committer.setName("lafin716");
        committer.setEmail("lafin716@gmail.com");

        String content = Base64Utils.encodeToString("testtest".getBytes());

        System.out.println(content);

        commitFileRequest.setAuthor(author);
        commitFileRequest.setCommitter(committer);
        commitFileRequest.setBranch("main");
        commitFileRequest.setMessage("docs: TIL 추가 테스트 by API");
        commitFileRequest.setContent(content);

        var result = repositoryService.commit(commitPathRequest, commitFileRequest);

        System.out.println(result);
    }


}