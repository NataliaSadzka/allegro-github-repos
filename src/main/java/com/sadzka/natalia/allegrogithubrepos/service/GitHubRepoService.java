package com.sadzka.natalia.allegrogithubrepos.service;

import com.sadzka.natalia.allegrogithubrepos.model.GitHubRepo;

import java.util.List;

/**
 * Service interface of GitHub repository object.
 *
 */
public interface GitHubRepoService {
    List<GitHubRepo> getGitHubReposListByUsername(String username);
    Integer getTotalStarsByUsername(String username);
}
