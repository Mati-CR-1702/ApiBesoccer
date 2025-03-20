package com.app.models.response.top5España;

import com.app.models.dto.top5España.TeamFiltradoDTO;

import java.util.List;

public class TopTeamsResponseDTO {

    public String league;
    public List<TeamFiltradoDTO> topTeams;

    public TopTeamsResponseDTO(String league, List<TeamFiltradoDTO> topTeams) {
        this.league = league;
        this.topTeams = topTeams;
    }
}
