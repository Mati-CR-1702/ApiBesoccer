package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.CompetitionDToOriginal;

import java.util.List;

public class CompetitionListResponseDTO {

        public String continent;
        public List<CompetitionDToOriginal> competitions;



        public CompetitionListResponseDTO(String continent, List<CompetitionDToOriginal> competitions) {
            this.continent = continent;
            this.competitions = competitions;
        }
    }

