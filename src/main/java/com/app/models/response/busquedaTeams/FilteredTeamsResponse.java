package com.app.models.response.busquedaTeams;

import com.app.models.dto.busquedaTeams.FilteredTeamDTO;

import java.util.List;

public class FilteredTeamsResponse {

    private String league;
    private List<FilteredTeamDTO> teams;

    public FilteredTeamsResponse(String league, List<FilteredTeamDTO> teams) {
        this.league = league;
        this.teams = teams;
    }

    public String getLeague() {
        return league;
    }

    public List<FilteredTeamDTO> getTeams() {
        return teams;
    }
}
