package com.app.models.dto.busquedaTeams;

public class FiltradoTeamsDto {

    public String id;
    public String nameShow;
    public String group_code;
    public String basealias;
    public String fullName;
    public String short_name;
    public String countryCode;
    public String nameShowTeam;
    public int gender;

    public FiltradoTeamsDto(String id, String nameShow, String group_code,
                            String basealias, String fullName, String short_name,
                            String countryCode, String nameShowTeam, int gender) {
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
}
