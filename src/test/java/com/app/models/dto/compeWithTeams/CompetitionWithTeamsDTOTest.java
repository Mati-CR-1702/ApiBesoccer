package com.app.models.dto.compeWithTeams;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionWithTeamsDTOTest {

    @Test
    void testConstructorAndGetters() {
        List<TeamWithCompetitionDTO> teams = Collections.emptyList();

        CompetitionWithTeamsDTO dto = new CompetitionWithTeamsDTO(
                "123",
                "Champions League",
                "Europe",
                "logo.png",
                "flag.png",
                teams
        );

        assertEquals("123", dto.getCompetitionId());
        assertEquals("Champions League", dto.getCompetitionName());
        assertEquals("Europe", dto.getCountry());
        assertEquals("logo.png", dto.getLogo());
        assertEquals("flag.png", dto.getFlag());
        assertEquals(teams, dto.getTeams());
    }

    @Test
    void testSetters() {
        CompetitionWithTeamsDTO dto = new CompetitionWithTeamsDTO(null, null, null, null, null, null);

        dto.setCompetitionId("456");
        dto.setCompetitionName("Europa League");
        dto.setCountry("Europe");
        dto.setLogo("europa_logo.png");
        dto.setFlag("europa_flag.png");
        dto.setTeams(Collections.emptyList());

        assertEquals("456", dto.getCompetitionId());
        assertEquals("Europa League", dto.getCompetitionName());
        assertEquals("Europe", dto.getCountry());
        assertEquals("europa_logo.png", dto.getLogo());
        assertEquals("europa_flag.png", dto.getFlag());
        assertEquals(Collections.emptyList(), dto.getTeams());
    }

}
