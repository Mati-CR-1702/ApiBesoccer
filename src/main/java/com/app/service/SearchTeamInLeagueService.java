package com.app.service;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import com.app.models.response.teamInLeague.FilteredTeamsResponse;

public interface SearchTeamInLeagueService {

    FilteredTeamsResponse getTeamsForLeague(String leagueId);

    FilteredTeamDTO searchTeamByName(String leagueId, String teamName);

}
