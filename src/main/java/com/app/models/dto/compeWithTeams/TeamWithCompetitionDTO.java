package com.app.models.dto.compeWithTeams;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamWithCompetitionDTO {

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


    public TeamWithCompetitionDTO(String id, String name, String groupCode, String country, String shield) {
        this.id = id;
        this.nameShow = name;
        this.groupCode = groupCode;
        this.countryCode = country;
        this.shield = shield;
    }
}
