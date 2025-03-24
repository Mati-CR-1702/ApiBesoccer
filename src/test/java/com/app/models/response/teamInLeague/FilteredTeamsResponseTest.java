package com.app.models.response.teamInLeague;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilteredTeamsResponseTest {

    @Test
    void testConstructorAndGetters() {

        List<FilteredTeamDTO> teams = Collections.singletonList(new FilteredTeamDTO(
                "12",
                "nameShow",
                "group_code",
                "basealias",
                "fullName",
                "short_name",
                "countryCode",
                "nameShowTeam",
                "1"));


        FilteredTeamsResponse response = new FilteredTeamsResponse("Premier League", teams);


        assertEquals("Premier League", response.getLeague());
        assertEquals(teams, response.getTeams());
    }

    @Test
    void testEmptyResponse() {

        FilteredTeamsResponse response = new FilteredTeamsResponse(null, null);

        assertNull(response.getLeague());
        assertNull(response.getTeams());
    }

}