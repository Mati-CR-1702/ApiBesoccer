package com.app.models.response.top5Spain;

import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Top5TeamsResponseTest {
    @Test
    void testConstructorAndAttributes() {

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


        Top5TeamsResponse response = new Top5TeamsResponse("La Liga", topTeams);


        assertEquals("La Liga", response.league);
        assertEquals(topTeams, response.topTeams);
    }

    @Test
    void testEmptyResponse() {

        Top5TeamsResponse response = new Top5TeamsResponse(null, null);


        assertNull(response.league);
        assertNull(response.topTeams);
    }

}