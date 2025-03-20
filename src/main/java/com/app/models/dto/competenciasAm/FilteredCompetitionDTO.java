package com.app.models.dto.competenciasAm;

public class FilteredCompetitionDTO {

    public String id;
    public String leagueId;
    public String name;
    public String country;
    public String flagUrl;
    public String logoUrl;


    public FilteredCompetitionDTO(String id, String leagueId , String name, String country, String flagUrl, String logoUrl) {
        this.id = id;
        this.leagueId = leagueId;
        this.name = name;
        this.country = country;
        this.flagUrl = flagUrl;
        this.logoUrl = logoUrl;
    }
}
