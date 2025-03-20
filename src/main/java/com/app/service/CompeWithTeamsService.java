package com.app.service;

import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamDTO1;

import java.util.List;

public interface CompeWithTeamsService {

    List<CompetitionWithTeamsDTO> getCompetitionsWithTeams();
}
