package com.app.models.dto.competenciasAm;

public class CompetitionDTO {
    public String id;
    public String leagueId;
    public String shortName;
    public String name;
    public String country;
    public String flagUrl;
    public String logoUrl;

    public CompetitionDTO(String id, String leagueId, String shortName, String name, String country, String flagUrl, String logoUrl) {
        this.id = id;
        this.leagueId = leagueId;
        this.shortName = shortName;
        this.name = name;
        this.country = country;
        this.flagUrl = flagUrl;
        this.logoUrl = logoUrl;
    }
}
