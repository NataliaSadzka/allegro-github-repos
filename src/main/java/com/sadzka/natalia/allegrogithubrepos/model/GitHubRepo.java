package com.sadzka.natalia.allegrogithubrepos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class for GitHub repository object.
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitHubRepo {
    private String name;

    @JsonProperty("stargazers_count")
    private Integer stars;
}
