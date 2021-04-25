package com.sadzka.natalia.allegrogithubrepos.exception;

/**
 * Custom exception for GitHub repository not found.
 *
 */
public class GitHubRepoNotFoundException extends RuntimeException {

    /**
     * Class constructor.
     *
     */
    public GitHubRepoNotFoundException() {
        super("GitHub repository not found");
    }
}
