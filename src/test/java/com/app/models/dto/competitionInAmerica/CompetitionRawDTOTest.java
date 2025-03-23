package com.app.models.dto.competitionInAmerica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionRawDTOTest {


    @Test
    void testSetters() {
        CompetitionRawDTO dto = new CompetitionRawDTO();
        dto.setId("2");
        dto.setLeague_id("202");
        dto.setName("La Liga");
        dto.setCountry("Spain");
        dto.setContinent("europe");
        dto.setFlag("spain_flag.png");
        dto.setLogo_png("spain_logo.png");

        assertEquals("2", dto.getId());
        assertEquals("202", dto.getLeague_id());
        assertEquals("La Liga", dto.getName());
        assertEquals("Spain", dto.getCountry());
        assertEquals("europe", dto.getContinent());
        assertEquals("spain_flag.png", dto.getFlag());
        assertEquals("spain_logo.png", dto.getLogo_png());
    }
  
}