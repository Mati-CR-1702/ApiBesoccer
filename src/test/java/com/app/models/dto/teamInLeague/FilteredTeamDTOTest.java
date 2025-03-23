package com.app.models.dto.teamInLeague;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilteredTeamDTOTest {

    @Test
    void testConstructorAndGetters() {
        FilteredTeamDTO dto = new FilteredTeamDTO(
                "12",
                "nameShow",
                "group_code",
                "basealias",
                "fullName",
                "short_name",
                "countryCode",
                "nameShowTeam",
                "1"
        );

        assertEquals("12", dto.getId());
        assertEquals("nameShow", dto.getNameShow());
        assertEquals("group_code", dto.getGroup_code());
        assertEquals("basealias", dto.getBasealias());
        assertEquals("fullName", dto.getFullName());
        assertEquals("short_name", dto.getShort_name());
        assertEquals("countryCode", dto.getCountryCode());
        assertEquals("nameShowTeam", dto.getNameShowTeam());
        assertEquals("1", dto.getGender());

    }

    @Test
    void testSetters(){
        FilteredTeamDTO dto = new FilteredTeamDTO( null, null, null, null, null, null, null, null, null);

        dto.setId("13");
        dto.setNameShow("nameShow2");
        dto.setGroup_code("group_code2");
        dto.setBasealias("basealias2");
        dto.setFullName("fullName2");
        dto.setShort_name("short_name2");
        dto.setCountryCode("countryCode2");
        dto.setNameShowTeam("nameShowTeam2");
        dto.setGender("2");


    }

}