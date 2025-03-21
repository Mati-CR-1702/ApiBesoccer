package com.app.models.response.competitionInAmerica;

import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;

import java.util.List;

public class CompetitionListResponse {

    private String continent;
    private List<CompetitionRawDTO> competitions;

    // Constructor
    public CompetitionListResponse(String continent, List<CompetitionRawDTO> competitions) {
        this.continent = continent;
        this.competitions = competitions;
    }

    // Getters y Setters
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public List<CompetitionRawDTO> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(List<CompetitionRawDTO> competitions) {
        this.competitions = competitions;
    }
}