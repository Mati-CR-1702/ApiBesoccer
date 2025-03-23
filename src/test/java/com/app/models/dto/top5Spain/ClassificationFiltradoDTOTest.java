package com.app.models.dto.top5Spain;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassificationFiltradoDTOTest {

    @Test
    void testConstructorAndGetters () {
        ClassificationFiltradoDTO classificationFiltradoDTO = new ClassificationFiltradoDTO(
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
        );

        assertEquals("123", classificationFiltradoDTO.getId());
        assertEquals("1", classificationFiltradoDTO.getGroup());
        assertEquals("Barcelona", classificationFiltradoDTO.getTeam());
        assertEquals("155", classificationFiltradoDTO.getPoints());
        assertEquals("13", classificationFiltradoDTO.getWins());
        assertEquals("5", classificationFiltradoDTO.getDraws());
        assertEquals("1", classificationFiltradoDTO.getLosses());
        assertEquals("45", classificationFiltradoDTO.getGf());
        assertEquals("12", classificationFiltradoDTO.getGa());
        assertEquals("33", classificationFiltradoDTO.getAvg());
        assertEquals("44", classificationFiltradoDTO.getAbbr());
        assertEquals("1", classificationFiltradoDTO.getPos());

    }

    @Test
    void testSetters(){
        ClassificationFiltradoDTO dto = new ClassificationFiltradoDTO( null, null, null, null, null, null, null, null, null, null, null, null);

        dto.setId("123");
        dto.setGroup("1");
        dto.setTeam("Barcelona");
        dto.setPoints("155");
        dto.setWins("13");
        dto.setDraws("5");
        dto.setLosses("1");
        dto.setGf("45");
        dto.setGa("12");
        dto.setAvg("33");
        dto.setAbbr("44");
        dto.setPos("1");


    }
}