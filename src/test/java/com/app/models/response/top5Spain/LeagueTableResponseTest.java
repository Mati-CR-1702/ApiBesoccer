package com.app.models.response.top5Spain;

import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTableResponseTest {

    @Test
    void testGetTeams() {
        // Crear una lista simulada de ClassificationFiltradoDTO
        List<ClassificationFiltradoDTO> table = Collections.singletonList(new ClassificationFiltradoDTO(
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

        // Crear un objeto de LeagueTableResponse y asignar la lista al atributo público
        LeagueTableResponse response = new LeagueTableResponse();
        response.table = table;

        // Verificar que el getter devuelve la lista correctamente
        assertEquals(table, response.getTeams());
    }

    @Test
    void testEmptyTable() {
        // Crear un objeto de LeagueTableResponse sin asignar valores
        LeagueTableResponse response = new LeagueTableResponse();

        // Verificar que el getter devuelve null inicialmente
        assertNull(response.getTeams());
    }

}