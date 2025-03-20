package com.app.models.dto.compeWithTeams;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CompetitionResponse {


    @JsonProperty("category")
    public List<CompetitionDTO> competitions;

    public List<CompetitionDTO> getCompetitions() {
        return competitions;
    }
}
