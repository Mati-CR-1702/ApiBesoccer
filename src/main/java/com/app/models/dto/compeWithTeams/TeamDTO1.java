package com.app.models.dto.compeWithTeams;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TeamDTO1 {

    @JsonProperty("id")
    public String id;

    @JsonProperty("nameShow")
    public String nameShow;

    @JsonProperty("group_code")
    public String groupCode;

    @JsonProperty("countryCode")
    public String countryCode;

    @JsonProperty("shield")
    public String shield;


    public TeamDTO1(String id, String name, String groupCode, String country, String shield) {
        this.id = id;
        this.nameShow = name;
        this.groupCode = groupCode;
        this.countryCode = country;
        this.shield = shield;
    }
}
