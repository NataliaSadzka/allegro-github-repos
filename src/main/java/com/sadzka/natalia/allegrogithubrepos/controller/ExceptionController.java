package com.sadzka.natalia.allegrogithubrepos.controller;

import com.sadzka.natalia.allegrogithubrepos.exception.GitHubRepoNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controller for exceptions.
 *
 */
@Log4j2
@RestControllerAdvice
public class ExceptionController {

    /**
     * Method to handle GitHub repository not found exception.
     *
     * @return message "GitHub repository for user not found"
     */
    @ExceptionHandler(GitHubRepoNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String GitHubRepoNotFound() {
        log.info("GitHub repository not found");
        return "GitHub repository for user not found";
    }
}
