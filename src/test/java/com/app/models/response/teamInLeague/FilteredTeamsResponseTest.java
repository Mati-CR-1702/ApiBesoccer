package com.app.models.response.teamInLeague;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteredTeamsResponseTest {

    @Test
    void testConstructorAndGetters() {
        // Crear una lista simulada de FilteredTeamDTO
        List<FilteredTeamDTO> teams = Collections.singletonList(new FilteredTeamDTO(
                "12",
                "nameShow",
                "group_code",
                "basealias",
                "fullName",
                "short_name",
                "countryCode",
                "nameShowTeam",
                "1"));

        // Crear un objeto usando el constructor
        FilteredTeamsResponse response = new FilteredTeamsResponse("Premier League", teams);

        // Verificar que los valores se asignaron correctamente
        assertEquals("Premier League", response.getLeague());
        assertEquals(teams, response.getTeams());
    }

    @Test
    void testEmptyResponse() {
        // Crear un objeto con valores nulos
        FilteredTeamsResponse response = new FilteredTeamsResponse(null, null);

        // Verificar que los valores iniciales son nulos
        assertNull(response.getLeague());
        assertNull(response.getTeams());
    }

}