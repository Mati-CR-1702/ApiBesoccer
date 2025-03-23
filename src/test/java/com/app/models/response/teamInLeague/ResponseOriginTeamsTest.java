package com.app.models.response.teamInLeague;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseOriginTeamsTest {

    @Test
    void testGetTeams() {
        // Crear una lista simulada de FilteredTeamDTO
        List<FilteredTeamDTO> teams = Collections.singletonList(new FilteredTeamDTO("12",
                "nameShow",
                "group_code",
                "basealias",
                "fullName",
                "short_name",
                "countryCode",
                "nameShowTeam",
                "1"));

        // Crear un objeto de ResponseOriginTeams y asignar la lista al atributo público
        ResponseOriginTeams response = new ResponseOriginTeams();
        response.team = teams;

        // Verificar que el getter devuelve la lista correctamente
        assertEquals(teams, response.getTeams());
    }

    @Test
    void testEmptyTeams() {
        // Crear un objeto de ResponseOriginTeams sin asignar valores
        ResponseOriginTeams response = new ResponseOriginTeams();

        // Verificar que el getter devuelve null inicialmente
        assertNull(response.getTeams());
    }

}