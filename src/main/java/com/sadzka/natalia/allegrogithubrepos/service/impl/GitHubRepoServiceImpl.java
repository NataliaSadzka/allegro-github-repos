package com.sadzka.natalia.allegrogithubrepos.service.impl;

import com.sadzka.natalia.allegrogithubrepos.exception.GitHubRepoNotFoundException;
import com.sadzka.natalia.allegrogithubrepos.model.GitHubRepo;
import com.sadzka.natalia.allegrogithubrepos.service.GitHubRepoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Service implementation class for GitHub repository service.
 *
 */
@Log4j2
@Service
public class GitHubRepoServiceImpl implements GitHubRepoService {

    private final WebClient client;

    /**
     * Class constructor.
     *
     */
    public GitHubRepoServiceImpl() {
        client = WebClient.create();
    }

    /**
     * Gets list of names and stars of GitHub repositories for username.
     *
     * @param username - GitHub username
     * @return list names and stars of GitHub repository for username
     */
    public List<GitHubRepo> getGitHubReposListByUsername(String username) {
        log.info("Called method getGitHubReposListByUsername with username: {}", username);
        try {
            return client.get()
                    .uri("https://api.github.com/users/" + username + "/repos")
                    .retrieve()
                    .onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                            clientResponse -> Mono.error(new GitHubRepoNotFoundException()))
                    .bodyToFlux(GitHubRepo.class)
                    .onErrorStop()
                    .collectList()
                    .block();
        } catch (GitHubRepoNotFoundException e) {
            log.error("GitHub repository for user {} not found", username);
            throw e;
        }
    }

    /**
     * Gets total stars of GitHub repositories for username.
     *
     * @param username - GitHub username
     * @return total stars of GitHub repository for username
     */
    public Integer getTotalStarsByUsername(String username) {
        log.info("Called method getTotalStarsByUsername with username: {}", username);
        List<GitHubRepo> gitHubRepoList = getGitHubReposListByUsername(username);

        Integer totalStars = 0;
        for (GitHubRepo gitHubRepo : gitHubRepoList) {
            totalStars += gitHubRepo.getStars();
        }
        return totalStars;
    }
}
