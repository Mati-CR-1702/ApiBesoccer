package com.app.models.response.teamInLeague;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseOriginTeams {

    @JsonProperty("team")
    public List<FilteredTeamDTO> team;

    public List<FilteredTeamDTO> getTeams() {
        return team;
    }



}
