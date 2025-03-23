package com.app.models.response.competitionInAmerica;

import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseCompetitionsTest {

    @Test
    void testGetCompetitions() {
        // Crear una lista simulada de CompetitionRawDTO
        List<CompetitionRawDTO> competitions = Collections.singletonList(new CompetitionRawDTO());

        // Crear un objeto de ResponseCompetitions y asignar la lista al atributo público
        ResponseCompetitions response = new ResponseCompetitions();
        response.category = competitions;

        // Verificar que el getter devuelve la lista correctamente
        assertEquals(competitions, response.getCompetitions());
    }

}