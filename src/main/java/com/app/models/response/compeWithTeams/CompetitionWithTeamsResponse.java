package com.app.models.response.compeWithTeams;

import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CompetitionWithTeamsResponse {

    @JsonProperty("team")
    public List<TeamWithCompetitionDTO> teams;

    public List<TeamWithCompetitionDTO> getTeams() {
        return teams;
    }
}
