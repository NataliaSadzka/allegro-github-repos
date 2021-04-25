package com.sadzka.natalia.allegrogithubrepos.controller;

import com.sadzka.natalia.allegrogithubrepos.model.GitHubRepo;
import com.sadzka.natalia.allegrogithubrepos.service.GitHubRepoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class of GitHub repository object.
 *
 */
@Log4j2
@RestController
public class GitHubRepoController {

    private final GitHubRepoService gitHubRepoService;

    /**
     * Class constructor.
     *
     * @param gitHubRepoService - GitHub repository service
     */
    public GitHubRepoController(GitHubRepoService gitHubRepoService) {
        this.gitHubRepoService = gitHubRepoService;
    }

    /**
     * Gets list of names and stars of GitHub repositories for username.
     *
     * @param username - GitHub username
     * @return list names and stars of GitHub repository for username
     */
    @GetMapping(value = "/{username}/list", produces = "application/json")
    public List<GitHubRepo> getGitHubReposListByUsername(@PathVariable String username) {
        log.info("Called method getGitHubReposListByUsername with username: {}", username);
        return gitHubRepoService.getGitHubReposListByUsername(username);
    }

    /**
     * Gets total stars of GitHub repositories for username.
     *
     * @param username - GitHub username
     * @return list names and stars of GitHub repository for username
     */
    @GetMapping(value = "/{username}/totalStars", produces = "application/json")
    public Integer getTotalStarsByUsername(@PathVariable String username) {
        log.info("Called method getTotalStarsByUsername with username: {}", username);
        return gitHubRepoService.getTotalStarsByUsername(username);
    }
}
