package com.app.models.response.top5Spain;

import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTableResponseTest {

    @Test
    void testGetTeams() {

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


        LeagueTableResponse response = new LeagueTableResponse();
        response.table = table;


        assertEquals(table, response.getTeams());
    }

    @Test
    void testEmptyTable() {

        LeagueTableResponse response = new LeagueTableResponse();


        assertNull(response.getTeams());
    }

}