package com.app.models.dto.compeWithTeams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamWithCompetitionDTOTest {

    @Test
    void testGettersAndSetters() {
        TeamWithCompetitionDTO dto = new TeamWithCompetitionDTO();

        dto.setId("1");
        dto.setGroup_code("A");
        dto.setShield("shield.png");
        dto.setNameShow("Team A");
        dto.setCountryCode("US");

        assertEquals("1", dto.getId());
        assertEquals("A", dto.getGroup_code());
        assertEquals("shield.png", dto.getShield());
        assertEquals("Team A", dto.getNameShow());
        assertEquals("US", dto.getCountryCode());
    }

}