package com.sadzka.natalia.allegrogithubrepos;

import com.sadzka.natalia.allegrogithubrepos.controller.ExceptionController;
import com.sadzka.natalia.allegrogithubrepos.controller.GitHubRepoController;
import com.sadzka.natalia.allegrogithubrepos.service.GitHubRepoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for application context.
 *
 */
@SpringBootTest
class AllegroGithubReposApplicationTests {

    @Autowired
    private GitHubRepoController gitHubRepoController;

    @Autowired
    private ExceptionController exceptionController;

    @Autowired
    private GitHubRepoService gitHubRepoService;

    /**
     * Tests application controllers.
     *
     */
    @Test
    void contextLoadsControllers() {
        Assertions.assertThat(gitHubRepoController).isNotNull();
        Assertions.assertThat(exceptionController).isNotNull();
    }

    /**
     * Tests application services.
     *
     */
    @Test
    void contextLoadsServices() {
        Assertions.assertThat(gitHubRepoService).isNotNull();
    }
}
