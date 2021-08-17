package com.lafin.tiltheend.thirdparty.github.service;

import com.lafin.tiltheend.thirdparty.github.config.GithubApi;
import com.lafin.tiltheend.thirdparty.github.constant.RepoApi;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitFileRequest;
import com.lafin.tiltheend.thirdparty.github.dto.request.CommitPathRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.annotation.Resource;

@Service
public class RepositoryService extends GithubService {

    @Resource(name = "personalAccessToken")
    private String personalAccessToken;

    @Resource(name = "githubName")
    public String githubName;

    @Resource(name = "githubEmail")
    public String githubEmail;

    @Resource(name = "owner")
    public String owner;

    @Resource(name = "repo")
    public String repo;

    @Resource(name = "pathPrefix")
    public String pathPrefix;

    @Resource(name = "branch")
    public String branch;

    public String commit(CommitPathRequest commitPathRequest, CommitFileRequest commitFileRequest) {
        return (String) restTemplateBuilder.url(GithubApi.API_URL)
                .method(HttpMethod.PUT)
                .path(RepoApi.UPLOAD_FILE)
                .pathExpend(
                        commitPathRequest.getOwner(),
                        commitPathRequest.getRepo(),
                        commitPathRequest.getPath())
                .contentType(defaultContentType)
                .headers(getTokenHeader(personalAccessToken))
                .request(commitFileRequest)
                .response(String.class)
                .build()
                .getBody();
    }

    // 미리 yaml 파일에 정의 된 리소스 정보로 커밋
    public String preparedCommit(String path, String title, String content) {
        CommitPathRequest commitPathRequest = new CommitPathRequest(owner, repo, pathPrefix + path);

        CommitFileRequest commitFileRequest = new CommitFileRequest();
        CommitFileRequest.Author author = new CommitFileRequest.Author();
        author.setName(githubName);
        author.setEmail(githubEmail);

        CommitFileRequest.Committer committer = new CommitFileRequest.Committer();
        committer.setName(githubName);
        committer.setEmail(githubEmail);

        commitFileRequest.setAuthor(author);
        commitFileRequest.setCommitter(committer);
        commitFileRequest.setBranch(branch);
        commitFileRequest.setMessage(title);
        commitFileRequest.setContent(Base64Utils.encodeToString(content.getBytes()));

        return commit(commitPathRequest, commitFileRequest);
    }

    @Override
    public boolean support(Class<?> clazz) {
        return this.getClass().getTypeName().equals(clazz.getTypeName());
    }
}
