package com.app.models.response.top5España;

import com.app.models.dto.top5España.TeamDTO;

import java.util.List;

public class TopTeamsResponseDTO {

    public String league;
    public List<TeamDTO> topTeams;

    public TopTeamsResponseDTO(String league, List<TeamDTO> topTeams) {
        this.league = league;
        this.topTeams = topTeams;
    }
}
