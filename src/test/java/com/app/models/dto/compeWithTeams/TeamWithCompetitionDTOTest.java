package com.app.models.dto.compeWithTeams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamWithCompetitionDTOTest {

    @Test
    void testGettersAndSetters() {
        // Crear un objeto vacío
        TeamWithCompetitionDTO dto = new TeamWithCompetitionDTO();

        // Usar los setters para asignar valores
        dto.setId("1");
        dto.setGroup_code("A");
        dto.setShield("shield.png");
        dto.setNameShow("Team A");
        dto.setCountryCode("US");

        // Verificar que los valores se asignaron correctamente
        assertEquals("1", dto.getId());
        assertEquals("A", dto.getGroup_code());
        assertEquals("shield.png", dto.getShield());
        assertEquals("Team A", dto.getNameShow());
        assertEquals("US", dto.getCountryCode());
    }

}