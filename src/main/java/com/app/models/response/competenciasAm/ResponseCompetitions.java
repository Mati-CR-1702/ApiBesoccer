package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.Competition;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCompetitions {

    public List<Competition> category;

    public List<Competition> getCompetitions() {
        return category;
    }

}
