package com.app.client;

import com.app.models.response.compeWithTeams.CompetitionWithTeamsResponse;
import com.app.models.response.competitionInAmerica.ResponseCompetitions;
import com.app.models.response.teamInLeague.ResponseOriginTeams;
import com.app.models.response.top5Spain.LeagueTableResponse;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class BesoccerClientTest {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @Test
    void testGetCompetitions() {
        // Simular una respuesta de la API externa
        ResponseCompetitions response = besoccerClient.getCompetitions(
                "test-api-key", "UTC", "competitions", "filter", "json"
        );

        // Verificar que la respuesta no sea nula
        assertNotNull(response);
        assertNull(response.getCompetitions()); // Verificar que el fallback devuelve una respuesta vacía
    }

    @Test
    void testGetClasificaciones() {
        LeagueTableResponse response = besoccerClient.getClasificaciones(
                "test-api-key", "json", "league_table", "123", "A", "classification"
        );

        assertNotNull(response);
        assertNull(response.getTeams()); // Verificar que el fallback devuelve una respuesta vacía

    }

    @Test
    void testGetTeamsForLeague() {
        ResponseOriginTeams response = besoccerClient.getTeamsForLeague(
                "test-api-key", "json", "teams", "123"
        );

        assertNotNull(response);
        assertNull(response.getTeams()); // Verificar que el fallback devuelve una respuesta vacía
    }

    @Test
    void testGetTeamForCompetition() {
        CompetitionWithTeamsResponse response = besoccerClient.getTeamForCompetition(
                "test-api-key", "json", "teams", "123"
        );

        assertNotNull(response);
        assertNull(response.getTeams()); // Verificar que el fallback devuelve una respuesta vacía
    }

}