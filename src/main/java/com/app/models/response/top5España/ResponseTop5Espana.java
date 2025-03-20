package com.app.models.response.top5España;

import com.app.models.dto.top5España.TeamFiltradoDTO;

import java.util.List;

public class ResponseTop5Espana {

    public List<TeamFiltradoDTO> table;

    public List<TeamFiltradoDTO> getTeams() {
        return table;
    }
}
