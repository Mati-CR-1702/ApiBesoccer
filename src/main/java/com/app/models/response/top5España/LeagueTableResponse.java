package com.app.models.response.top5España;

import com.app.models.dto.top5España.ClassificationFiltradoDTO;

import java.util.List;

public class LeagueTableResponse {

    public List<ClassificationFiltradoDTO> table;

    public List<ClassificationFiltradoDTO> getTeams() {
        return table;
    }
}
