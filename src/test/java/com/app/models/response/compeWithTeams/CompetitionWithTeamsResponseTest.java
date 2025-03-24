package com.app.models.response.compeWithTeams;

import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionWithTeamsResponseTest {

    @Test
    void testGetTeams() {

        List<TeamWithCompetitionDTO> teams = Collections.singletonList(new TeamWithCompetitionDTO());

        CompetitionWithTeamsResponse response = new CompetitionWithTeamsResponse();
        response.setTeams(teams);


        assertEquals(teams, response.getTeams());
    }

    @Test
    void testEmptyTeams() {

        CompetitionWithTeamsResponse response = new CompetitionWithTeamsResponse();


        assertNull(response.getTeams());
    }
}

