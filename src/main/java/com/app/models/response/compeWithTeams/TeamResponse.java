package com.app.models.response.compeWithTeams;

import com.app.models.dto.compeWithTeams.TeamWithTeamDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamResponse {

    @JsonProperty("team")
    public List<TeamWithTeamDTO> teams;

    public List<TeamWithTeamDTO> getTeams() {
        return teams;
    }
}
