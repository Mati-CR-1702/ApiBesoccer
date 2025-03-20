package com.app.models.dto.compeWithTeams;

import java.util.List;

public class CompetitionWithTeamsDTO {

    public String competitionId;
    public String competitionName;
    public String country;
    public String flag;
    public String logo;
    public List<TeamWithCompetitionDTO> teams;

    public CompetitionWithTeamsDTO(String competitionId,
                                   String competitionName,
                                   String country, String flag,
                                   String logo, List<TeamWithCompetitionDTO> teams) {
        this.competitionId = competitionId;
        this.competitionName = competitionName;
        this.country = country;
        this.flag = flag;
        this.logo = logo;
        this.teams = teams;
    }
}
