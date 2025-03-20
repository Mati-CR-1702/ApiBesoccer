package com.app.models.response.competitionInAmerica;

import com.app.models.dto.competitionInAmerica.FilteredCompetitionDTO;

import java.util.List;

public class CompetitionListResponse {

        public String continent;
        public List<FilteredCompetitionDTO> competitions;



        public CompetitionListResponse(String continent, List<FilteredCompetitionDTO> competitions) {
            this.continent = continent;
            this.competitions = competitions;
        }
    }

