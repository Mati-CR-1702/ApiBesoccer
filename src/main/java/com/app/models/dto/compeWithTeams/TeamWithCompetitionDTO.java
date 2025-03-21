package com.app.models.dto.compeWithTeams;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamWithCompetitionDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("group_code")
    private String groupCode;

    @JsonProperty("shield")
    private String shield;

    @JsonProperty("nameShow")
    private String nameShow;

    @JsonProperty("countryCode")
    private String countryCode;

    public TeamWithCompetitionDTO(String id, String groupCode, String nameShow, String shield, String countryCode) {
        this.id = id;
        this.groupCode = groupCode;
        this.nameShow = nameShow;
        this.shield = shield;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getNameShow() {
        return nameShow;
    }

    public void setNameShow(String nameShow) {
        this.nameShow = nameShow;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
