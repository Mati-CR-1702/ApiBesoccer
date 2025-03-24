package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.configs.LoggerConfig;
import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import com.app.models.response.competitionInAmerica.ResponseCompetitions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CompetitionServiceImplTest {

    @InjectMocks
    private CompetitionServiceImpl competitionService;

    @Mock
    private BesoccerClient besoccerClient;

    @Mock
    private LoggerConfig loggerConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        competitionService.apiKey = "test-api-key";
        competitionService.timezone = "Europe/Madrid";
        competitionService.requestType = "categories";
        competitionService.filter = "all";
        competitionService.format = "json";
        competitionService.continentName = "América";
        competitionService.continentCode = "am";


        when(loggerConfig.getCompetitionsAmerica()).thenReturn("Buscando competencias en América");
        when(loggerConfig.noCompetitionsFound()).thenReturn("No se encontraron competencias en América.");
        when(loggerConfig.foundCompetitions(anyInt())).thenAnswer(invocation ->
                "Competencias encontradas: " + invocation.getArgument(0)
        );
    }


    @Test
    void testGetCompetitionsInAmerica() {

        CompetitionRawDTO competition1 = new CompetitionRawDTO();
        competition1.setId("1");
        competition1.setContinent("am");
        competition1.setName("Copa América");

        CompetitionRawDTO competition2 = new CompetitionRawDTO();
        competition2.setId("2");
        competition2.setContinent("eu");
        competition2.setName("Eurocopa");

        ResponseCompetitions mockResponse = new ResponseCompetitions();
        mockResponse.category = Arrays.asList(competition1, competition2);


        when(besoccerClient.getCompetitions(
                anyString(), anyString(), anyString(), anyString(), anyString()
        )).thenReturn(mockResponse);


        var response = competitionService.getCompetitionsInAmerica();


        assertNotNull(response);
        assertEquals(1, response.getCompetitions().size());
        assertEquals("Copa América", response.getCompetitions().get(0).getName());

        verify(besoccerClient, times(1)).getCompetitions(
                "test-api-key", "Europe/Madrid", "categories", "all", "json"
        );


        verify(loggerConfig, times(1)).getCompetitionsAmerica();
        verify(loggerConfig, times(1)).foundCompetitions(1);
    }

}