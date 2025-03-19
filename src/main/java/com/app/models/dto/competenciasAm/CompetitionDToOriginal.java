package com.app.models.dto.competenciasAm;

public class CompetitionDToOriginal {

    public String id;
    public String leagueId;
    public String name;
    public String country;
    public String flagUrl;
    public String logoUrl;


    public CompetitionDToOriginal(String id, String leagueId , String name, String country, String flagUrl, String logoUrl) {
        this.id = id;
        this.leagueId = leagueId;
        this.name = name;
        this.country = country;
        this.flagUrl = flagUrl;
        this.logoUrl = logoUrl;
    }
}
