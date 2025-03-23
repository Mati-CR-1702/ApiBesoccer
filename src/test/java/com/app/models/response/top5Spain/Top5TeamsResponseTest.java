package com.app.models.response.top5Spain;

import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Top5TeamsResponseTest {
    @Test
    void testConstructorAndAttributes() {
        // Crear una lista simulada de ClassificationFiltradoDTO
        List<ClassificationFiltradoDTO> topTeams = Collections.singletonList(new ClassificationFiltradoDTO(
                "123",
                "1",
                "Barcelona",
                "155",
                "13",
                "5",
                "1",
                "45",
                "12",
                "33",
                "44",
                "1"
        ));

        // Crear un objeto usando el constructor
        Top5TeamsResponse response = new Top5TeamsResponse("La Liga", topTeams);

        // Verificar que los valores se asignaron correctamente
        assertEquals("La Liga", response.league);
        assertEquals(topTeams, response.topTeams);
    }

    @Test
    void testEmptyResponse() {
        // Crear un objeto con valores nulos
        Top5TeamsResponse response = new Top5TeamsResponse(null, null);

        // Verificar que los valores iniciales son nulos
        assertNull(response.league);
        assertNull(response.topTeams);
    }

}