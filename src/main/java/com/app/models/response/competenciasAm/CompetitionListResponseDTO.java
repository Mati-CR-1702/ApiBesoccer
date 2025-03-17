package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.CompetitionDTO;

import java.util.List;

public class CompetitionListResponseDTO {

        public String continent;
        public List<CompetitionDTO> competitions;

        public CompetitionListResponseDTO(String continent, List<CompetitionDTO> competitions) {
            this.continent = continent;
            this.competitions = competitions;
        }
    }

