package com.sadzka.natalia.allegrogithubrepos.controller;

import com.sadzka.natalia.allegrogithubrepos.exception.GitHubRepoNotFoundException;
import com.sadzka.natalia.allegrogithubrepos.model.GitHubRepo;
import com.sadzka.natalia.allegrogithubrepos.service.GitHubRepoService;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Test class for GitHubRepoController.class.
 *
 */
@Log4j2
@WebMvcTest(GitHubRepoController.class)
public class GitHubRepoControllerTest {

    @MockBean
    private GitHubRepoService gitHubRepoService;

    private MockMvc mockMvc;

    /**
     * Creates mockMvc object for tests. Executes before each test.
     *
     */
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GitHubRepoController(gitHubRepoService))
                .setControllerAdvice(new ExceptionController())
                .build();
    }

    /**
     * Tests getGitHubReposListByUsername method with success result.
     *
     * @throws Exception
     */
    @Test
    public void getGitHubReposListByUsernameTestSuccess() throws Exception {
        log.info("Execution of getGitHubReposListByUsernameTestSuccess");
        when(gitHubRepoService.getGitHubReposListByUsername("correctUsername")).thenReturn(prepareGitHubRepos());

        mockMvc.perform(MockMvcRequestBuilders.get("/correctUsername/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{'name':'repo1','stargazers_count':5},{'name':'repo2','stargazers_count':3}]"));
    }

    /**
     * Tests getGitHubReposListByUsername method with fail result.
     *
     * @throws Exception
     */
    @Test
    public void getGitHubReposListByUsernameTestFail() throws Exception {
        log.info("Execution of getGitHubReposListByUsernameTestFail");
        when(gitHubRepoService.getGitHubReposListByUsername("incorrectUsername")).thenThrow(new GitHubRepoNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/incorrectUsername/list"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("GitHub repository for user not found"));
    }

    /**
     * Tests getTotalStarsByUsername method with success result.
     *
     * @throws Exception
     */
    @Test
    public void getTotalStarsByUsernameTestSuccess() throws Exception {
        log.info("Execution of getTotalStarsByUsernameTestSuccess");
        when(gitHubRepoService.getTotalStarsByUsername("correctUsername")).thenReturn(8);

        mockMvc.perform(MockMvcRequestBuilders.get("/correctUsername/totalStars"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    /**
     * Tests getTotalStarsByUsername method with fail result.
     *
     * @throws Exception
     */
    @Test
    public void getTotalStarsByUsernameTestFail() throws Exception {
        log.info("Execution of getTotalStarsByUsernameTestFail");
        when(gitHubRepoService.getTotalStarsByUsername("incorrectUsername")).thenThrow(new GitHubRepoNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/incorrectUsername/totalStars"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string("GitHub repository for user not found"));
    }

    /**
     * Creates list of GitHub repositories for tests.
     *
     * @return list of GitHub repositories
     */
    private List<GitHubRepo> prepareGitHubRepos() {
        GitHubRepo gr1 = new GitHubRepo("repo1", 5);
        GitHubRepo gr2 = new GitHubRepo("repo2", 3);

        List<GitHubRepo> githubRepos = new ArrayList<>();
        githubRepos.add(gr1);
        githubRepos.add(gr2);

        return githubRepos;
    }
}
