package com.app.models.response.compeWithTeams;

import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionWithTeamsResponseTest {

    @Test
    void testGetTeams() {
        // Crear una lista simulada de TeamWithCompetitionDTO
        List<TeamWithCompetitionDTO> teams = Collections.singletonList(new TeamWithCompetitionDTO());

        // Crear un objeto de CompetitionWithTeamsResponse y asignar la lista usando el setter
        CompetitionWithTeamsResponse response = new CompetitionWithTeamsResponse();
        response.setTeams(teams);

        // Verificar que el getter devuelve la lista correctamente
        assertEquals(teams, response.getTeams());
    }

    @Test
    void testEmptyTeams() {
        // Crear un objeto de CompetitionWithTeamsResponse sin asignar valores
        CompetitionWithTeamsResponse response = new CompetitionWithTeamsResponse();

        // Verificar que el getter devuelve null inicialmente
        assertNull(response.getTeams());
    }
}

