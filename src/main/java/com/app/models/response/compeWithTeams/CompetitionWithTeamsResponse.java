package com.app.models.response.compeWithTeams;

import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CompetitionWithTeamsResponse {

    @JsonProperty("team")
    private List<TeamWithCompetitionDTO> teams;

    public List<TeamWithCompetitionDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamWithCompetitionDTO> teams) {
        this.teams = teams;
    }
}
