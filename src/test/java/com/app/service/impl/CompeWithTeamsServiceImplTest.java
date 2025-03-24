package com.app.service.impl;


import com.app.client.BesoccerClient;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import com.app.models.response.compeWithTeams.CompetitionWithTeamsResponse;
import com.app.models.response.competitionInAmerica.ResponseCompetitions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class CompeWithTeamsServiceImplTest {

    @InjectMocks
    private CompeWithTeamsServiceImpl compeWithTeamsService;

    @Mock
    private BesoccerClient besoccerClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        compeWithTeamsService.apiKey = "test-api-key";
        compeWithTeamsService.competitionsRequestType = "test-request-type";
        compeWithTeamsService.competitionsFilter = "test-filter";
        compeWithTeamsService.competitionsTimezone = "test-timezone";
        compeWithTeamsService.competitionsFormat = "test-format";
        compeWithTeamsService.teamsRequestType = "test-teams-request-type";
        compeWithTeamsService.teamsFormat = "test-teams-format";
    }

    @Test
    void testGetCompetitionsWithTeams_exitosa() {

        CompetitionRawDTO competition1 = new CompetitionRawDTO();
        competition1.setId("1");
        competition1.setName("La Liga");
        competition1.setCountry("Spain");
        competition1.setLogo_png("logo1.png");
        competition1.setFlag("flag1.png");

        CompetitionRawDTO competition2 = new CompetitionRawDTO();
        competition2.setId("2");
        competition2.setName("Premier League");
        competition2.setCountry("England");
        competition2.setLogo_png("logo2.png");
        competition2.setFlag("flag2.png");

        ResponseCompetitions responseCompetitions = new ResponseCompetitions();
        responseCompetitions.category = List.of(competition1, competition2);

        when(besoccerClient.getCompetitions(
                eq("test-api-key"), eq("test-timezone"), eq("test-request-type"), eq("test-filter"), eq("test-format")
        )).thenReturn(responseCompetitions);


        TeamWithCompetitionDTO team1 = new TeamWithCompetitionDTO();
        team1.setId("1");
        team1.setNameShow("Real Madrid");
        team1.setShield("logo_team1.png");

        TeamWithCompetitionDTO team2 = new TeamWithCompetitionDTO();
        team2.setId("2");
        team2.setNameShow("Barcelona");
        team2.setShield("logo_team2.png");

        CompetitionWithTeamsResponse competitionWithTeamsResponse = new CompetitionWithTeamsResponse();
        competitionWithTeamsResponse.setTeams(List.of(team1, team2));

        when(besoccerClient.getTeamForCompetition(
                eq("test-api-key"), eq("test-teams-format"), eq("test-teams-request-type"), eq("1")
        )).thenReturn(competitionWithTeamsResponse);

        when(besoccerClient.getTeamForCompetition(
                eq("test-api-key"), eq("test-teams-format"), eq("test-teams-request-type"), eq("2")
        )).thenReturn(competitionWithTeamsResponse);


        List<CompetitionWithTeamsDTO> result = compeWithTeamsService.getCompetitionsWithTeams();


        assertNotNull(result);
        assertEquals(2, result.size());

        CompetitionWithTeamsDTO firstCompetition = result.get(0);
        assertEquals("1", firstCompetition.getCompetitionId());
        assertEquals("La Liga", firstCompetition.getCompetitionName());
        assertEquals(2, firstCompetition.getTeams().size());
        assertEquals("Real Madrid", firstCompetition.getTeams().get(0).getNameShow());

        CompetitionWithTeamsDTO secondCompetition = result.get(1);
        assertEquals("2", secondCompetition.getCompetitionId());
        assertEquals("Premier League", secondCompetition.getCompetitionName());
        assertEquals(2, secondCompetition.getTeams().size());
        assertEquals("Barcelona", secondCompetition.getTeams().get(1).getNameShow());


        verify(besoccerClient, times(1)).getCompetitions(
                eq("test-api-key"), eq("test-timezone"), eq("test-request-type"), eq("test-filter"), eq("test-format")
        );
        verify(besoccerClient, times(2)).getTeamForCompetition(
                eq("test-api-key"), eq("test-teams-format"), eq("test-teams-request-type"), anyString()
        );
    }


}