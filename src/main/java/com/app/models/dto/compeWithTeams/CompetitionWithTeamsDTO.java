package com.app.models.dto.compeWithTeams;

import java.util.List;

public class CompetitionWithTeamsDTO {

    private String competitionId;
    private String competitionName;
    private String country;
    private String flag;
    private String logo;
    private List<TeamWithCompetitionDTO> teams;

    public CompetitionWithTeamsDTO(String competitionId, String competitionName,
                                   String country, String logo, String flag,
                                   List<TeamWithCompetitionDTO> teams) {
        this.competitionId = competitionId;
        this.competitionName = competitionName;
        this.country = country;
        this.logo = logo;
        this.flag = flag;
        this.teams = teams;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<TeamWithCompetitionDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamWithCompetitionDTO> teams) {
        this.teams = teams;
    }

}
