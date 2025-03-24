package com.app.models.response.competitionInAmerica;

import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCompetitions {

    public List<CompetitionRawDTO> category;

    public List<CompetitionRawDTO> getCompetitions() {
        return category;
    }


}
