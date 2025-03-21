package com.app.models.dto.teamInLeague;


public class FilteredTeamDTO {

    private String id;
    private String nameShow;
    private String group_code;
    private String basealias;
    private String fullName;
    private String short_name;
    private String countryCode;
    private String nameShowTeam;
    private String gender;

    public FilteredTeamDTO(String id, String nameShow,
                           String group_code, String basealias,
                           String fullName, String short_name,
                           String countryCode,
                           String nameShowTeam,
                           String gender) {
        this.id = id;
        this.nameShow = nameShow;
        this.group_code = group_code;
        this.basealias = basealias;
        this.fullName = fullName;
        this.short_name = short_name;
        this.countryCode = countryCode;
        this.nameShowTeam = nameShowTeam;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameShow() {
        return nameShow;
    }

    public void setNameShow(String nameShow) {
        this.nameShow = nameShow;
    }

    public String getGroup_code() {
        return group_code;
    }

    public void setGroup_code(String group_code) {
        this.group_code = group_code;
    }

    public String getBasealias() {
        return basealias;
    }

    public void setBasealias(String basealias) {
        this.basealias = basealias;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNameShowTeam() {
        return nameShowTeam;
    }

    public void setNameShowTeam(String nameShowTeam) {
        this.nameShowTeam = nameShowTeam;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
