package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.CompetitionDToOriginal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCompetitions {

    public List<CompetitionDToOriginal> category;

    public List<CompetitionDToOriginal> getCompetitions() {
        return category;
    }

}
