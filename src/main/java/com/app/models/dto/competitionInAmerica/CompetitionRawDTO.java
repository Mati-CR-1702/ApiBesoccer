package com.app.models.dto.competitionInAmerica;




public class CompetitionRawDTO {

    public String id;
    public String league_id;
    public String name;
    public String country;
    public String continent;
    public String flag;
    public String logo_png;


    public CompetitionRawDTO(String id, String league_id, String name, String country, String flag, String continent, String logo_png) {
        this.id = id;
        this.league_id = league_id;
        this.name = name;
        this.country = country;
        this.flag = flag;
        this.continent = continent;
        this.logo_png = logo_png;
    }
}

