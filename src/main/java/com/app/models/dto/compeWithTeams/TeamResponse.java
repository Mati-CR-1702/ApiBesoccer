package com.app.models.dto.compeWithTeams;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamResponse {

    @JsonProperty("team")
    public List<TeamDTO1> teams;

    public List<TeamDTO1> getTeams() {
        return teams;
    }
}
