package com.app.models.response.competitionInAmerica;

import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionListResponseTest {

    @Test
    void testConstructorAndGetters() {
        // Crear una lista simulada de CompetitionRawDTO
        List<CompetitionRawDTO> competitions = Collections.singletonList(
                new CompetitionRawDTO()
        );

        // Crear un objeto usando el constructor
        CompetitionListResponse response = new CompetitionListResponse("America", competitions);

        // Verificar que los valores se asignaron correctamente
        assertEquals("America", response.getContinent());
        assertEquals(competitions, response.getCompetitions());
    }

    @Test
    void testSetters() {
        // Crear un objeto vacío
        CompetitionListResponse response = new CompetitionListResponse(null, null);

        // Crear una lista simulada de CompetitionRawDTO
        List<CompetitionRawDTO> competitions = Collections.singletonList(
                new CompetitionRawDTO()
        );

        // Usar los setters para asignar valores
        response.setContinent("Europe");
        response.setCompetitions(competitions);

        // Verificar que los valores se asignaron correctamente
        assertEquals("Europe", response.getContinent());
        assertEquals(competitions, response.getCompetitions());
    }

}