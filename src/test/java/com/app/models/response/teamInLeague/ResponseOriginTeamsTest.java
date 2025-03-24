package com.app.models.response.teamInLeague;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseOriginTeamsTest {

    @Test
    void testGetTeams() {

        List<FilteredTeamDTO> teams = Collections.singletonList(new FilteredTeamDTO("12",
                "nameShow",
                "group_code",
                "basealias",
                "fullName",
                "short_name",
                "countryCode",
                "nameShowTeam",
                "1"));


        ResponseOriginTeams response = new ResponseOriginTeams();
        response.team = teams;


        assertEquals(teams, response.getTeams());
    }

    @Test
    void testEmptyTeams() {

        ResponseOriginTeams response = new ResponseOriginTeams();


        assertNull(response.getTeams());
    }

}