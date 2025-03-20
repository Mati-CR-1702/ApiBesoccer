package com.app.models.response.top5España;

import com.app.models.dto.top5España.ClassificationFiltradoDTO;

import java.util.List;

public class Top5TeamsResponse {

    public String league;
    public List<ClassificationFiltradoDTO> topTeams;

    public Top5TeamsResponse(String league, List<ClassificationFiltradoDTO> topTeams) {
        this.league = league;
        this.topTeams = topTeams;
    }
}
