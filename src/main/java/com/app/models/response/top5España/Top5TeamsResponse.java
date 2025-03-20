package com.app.models.response.top5España;

import com.app.models.dto.top5España.TeamFiltradoDTO;

import java.util.List;

public class Top5TeamsResponse {

    public String league;
    public List<TeamFiltradoDTO> topTeams;

    public Top5TeamsResponse(String league, List<TeamFiltradoDTO> topTeams) {
        this.league = league;
        this.topTeams = topTeams;
    }
}
