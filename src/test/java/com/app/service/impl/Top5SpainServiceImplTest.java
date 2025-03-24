package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;
import com.app.models.response.top5Spain.LeagueTableResponse;
import com.app.models.response.top5Spain.Top5TeamsResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class Top5SpainServiceImplTest {

    @InjectMocks
    private Top5SpainServiceImpl top5SpainService;

    @Mock
    private BesoccerClient besoccerClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Simular valores de configuración
        top5SpainService.apiKey = "test-api-key";
        top5SpainService.leagueName = "La Liga";
        top5SpainService.leagueId = "123";
        top5SpainService.group = "A";
        top5SpainService.type = "classification";
        top5SpainService.format = "json";
        top5SpainService.requestType = "league_table";
    }

    @Test
    void testGetTop5Teams_exitosa() {
        // Simular la respuesta del cliente para la clasificación
        var team1 = new ClassificationFiltradoDTO("1", "A", "Real Madrid", "80", "25", "5", "8", "70", "30", "+40", "RM", "1");
        var team2 = new ClassificationFiltradoDTO("2", "A", "Barcelona", "78", "24", "6", "8", "68", "32", "+36", "FCB", "2");
        var team3 = new ClassificationFiltradoDTO("3", "A", "Atletico Madrid", "70", "21", "7", "10", "60", "40", "+20", "ATM", "3");
        var team4 = new ClassificationFiltradoDTO("4", "A", "Sevilla", "65", "19", "8", "11", "55", "45", "+10", "SEV", "4");
        var team5 = new ClassificationFiltradoDTO("5", "A", "Real Sociedad", "60", "18", "6", "14", "50", "50", "0", "RSO", "5");

        var leagueTableResponse = new LeagueTableResponse();
        leagueTableResponse.table = List.of(team1, team2, team3, team4, team5);

        when(besoccerClient.getClasificaciones(
                eq("test-api-key"), eq("json"), eq("league_table"), eq("123"), eq("A"), eq("classification")
        )).thenReturn(leagueTableResponse);

        // Llamar al mtodo que se está probando
        Top5TeamsResponse result = top5SpainService.getTop5Teams();

        // Verificar los resultados
        assertNotNull(result);
        assertEquals("La Liga", result.league);
        assertEquals(5, result.topTeams.size());

        ClassificationFiltradoDTO firstTeam = result.topTeams.get(0);
        assertEquals("1", firstTeam.getId());
        assertEquals("Real Madrid", firstTeam.getTeam());
        assertEquals("80", firstTeam.getPoints());

        ClassificationFiltradoDTO secondTeam = result.topTeams.get(1);
        assertEquals("2", secondTeam.getId());
        assertEquals("Barcelona", secondTeam.getTeam());
        assertEquals("78", secondTeam.getPoints());

        // Verificar que el mtodo del cliente fue llamado
        verify(besoccerClient, times(1)).getClasificaciones(
                eq("test-api-key"), eq("json"), eq("league_table"), eq("123"), eq("A"), eq("classification")
        );
    }

}