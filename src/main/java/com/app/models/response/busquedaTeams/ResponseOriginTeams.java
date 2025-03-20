package com.app.models.response.busquedaTeams;

import com.app.models.dto.busquedaTeams.TeamsDtoOriginal;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseOriginTeams {

    @JsonProperty("team")
    public List<TeamsDtoOriginal> team;

    public List<TeamsDtoOriginal> getTeams() {
        return team;
    }



}
