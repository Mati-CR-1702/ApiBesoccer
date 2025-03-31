package com.app.service;

import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;

import java.util.List;

public interface CompeWithTeamsService {

    List<CompetitionWithTeamsDTO> getCompetitions();

    CompetitionWithTeamsDTO getTeamsForCompetition(CompetitionWithTeamsDTO competition);
}

