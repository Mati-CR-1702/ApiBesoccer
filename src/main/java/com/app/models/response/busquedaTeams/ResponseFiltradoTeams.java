package com.app.models.response.busquedaTeams;

import com.app.models.dto.busquedaTeams.FiltradoTeamsDto;

import java.util.List;

public class ResponseFiltradoTeams {

    public String league;
    public List<FiltradoTeamsDto> teams;

    public ResponseFiltradoTeams(String league, List<FiltradoTeamsDto> teams) {
        this.league = league;
        this.teams = teams;
    }
}
