package com.app.models.response.top5Spain;

import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;

import java.util.List;

public class LeagueTableResponse {

    public List<ClassificationFiltradoDTO> table;

    public List<ClassificationFiltradoDTO> getTeams() {
        return table;
    }
}
