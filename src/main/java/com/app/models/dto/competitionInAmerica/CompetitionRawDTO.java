package com.app.models.dto.competitionInAmerica;

public class CompetitionRawDTO {

    private String id;
    private String league_id;
    private String name;
    private String country;
    private String continent;
    private String flag;
    private String logo_png;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLogo_png() {
        return logo_png;
    }

    public void setLogo_png(String logo_png) {
        this.logo_png = logo_png;
    }
}

