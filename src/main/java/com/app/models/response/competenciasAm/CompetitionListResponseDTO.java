package com.app.models.response.competenciasAm;

import com.app.models.dto.competenciasAm.CompetitionFiltradoDTO;

import java.util.List;

public class CompetitionListResponseDTO {

        public String continent;
        public List<CompetitionFiltradoDTO> competitions;



        public CompetitionListResponseDTO(String continent, List<CompetitionFiltradoDTO> competitions) {
            this.continent = continent;
            this.competitions = competitions;
        }
    }

