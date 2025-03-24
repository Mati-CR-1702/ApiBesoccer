package com.app.models.response.competitionInAmerica;

import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionListResponseTest {

    @Test
    void testConstructorAndGetters() {

        List<CompetitionRawDTO> competitions = Collections.singletonList(
                new CompetitionRawDTO()
        );

        CompetitionListResponse response = new CompetitionListResponse("America", competitions);

        assertEquals("America", response.getContinent());
        assertEquals(competitions, response.getCompetitions());
    }

    @Test
    void testSetters() {

        CompetitionListResponse response = new CompetitionListResponse(null, null);

        List<CompetitionRawDTO> competitions = Collections.singletonList(
                new CompetitionRawDTO()
        );

        response.setContinent("Europe");
        response.setCompetitions(competitions);

        assertEquals("Europe", response.getContinent());
        assertEquals(competitions, response.getCompetitions());
    }

}