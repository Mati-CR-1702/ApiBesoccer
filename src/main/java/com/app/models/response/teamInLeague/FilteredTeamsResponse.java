package com.app.models.response.teamInLeague;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;

import java.util.List;

public class FilteredTeamsResponse {

    private String league;
    public List<FilteredTeamDTO> teams;

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
