package com.app.models.response.busquedaTeams;

import com.app.models.dto.busquedaTeams.FilteredTeamDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseOriginTeams {

    @JsonProperty("team") // debo arreglar esto
    public List<FilteredTeamDTO> team;

    public List<FilteredTeamDTO> getTeams() {
        return team;
    }



}
