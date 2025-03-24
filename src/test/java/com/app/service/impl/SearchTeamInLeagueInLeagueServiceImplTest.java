package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import com.app.models.response.teamInLeague.FilteredTeamsResponse;
import com.app.models.response.teamInLeague.ResponseOriginTeams;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class SearchTeamInLeagueInLeagueServiceImplTest {

    @InjectMocks
    private SearchTeamInLeagueInLeagueServiceImpl searchTeamInLeagueService;

    @Mock
    private BesoccerClient besoccerClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        searchTeamInLeagueService.apiKey = "test-api-key";
        searchTeamInLeagueService.format = "test-format";
        searchTeamInLeagueService.requestType = "test-request-type";
    }

    @Test
    void testGetTeamsForLeague_exitosa() {

        var team1 = new FilteredTeamDTO("1", "Real Madrid", "A", "RM", "Real Madrid CF", "RM", "ES", "Real Madrid", "M");
        var team2 = new FilteredTeamDTO("2", "Barcelona", "B", "FCB", "FC Barcelona", "FCB", "ES", "Barcelona", "M");

        var responseOriginTeams = new ResponseOriginTeams();
        responseOriginTeams.team = List.of(team1, team2);

        when(besoccerClient.getTeamsForLeague(
                eq("test-api-key"), eq("test-format"), eq("test-request-type"), eq("123")
        )).thenReturn(responseOriginTeams);


        FilteredTeamsResponse result = searchTeamInLeagueService.getTeamsForLeague("123");


        assertNotNull(result);
        assertEquals("Liga ID: 123", result.getLeague());
        assertEquals(2, result.getTeams().size());

        FilteredTeamDTO firstTeam = result.getTeams().get(0);
        assertEquals("1", firstTeam.getId());
        assertEquals("Real Madrid", firstTeam.getNameShow());

        FilteredTeamDTO secondTeam = result.getTeams().get(1);
        assertEquals("2", secondTeam.getId());
        assertEquals("Barcelona", secondTeam.getNameShow());


        verify(besoccerClient, times(1)).getTeamsForLeague(
                eq("test-api-key"), eq("test-format"), eq("test-request-type"), eq("123")
        );
    }

}