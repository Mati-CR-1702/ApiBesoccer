package com.app.service;

import com.app.models.dto.busquedaTeams.FilteredTeamDTO;
import com.app.models.response.busquedaTeams.FilteredTeamsResponse;

public interface SearchLeagueAndTeamService {

    FilteredTeamsResponse getTeamsByLeague(String leagueId);

    FilteredTeamDTO searchTeamByName(String leagueId, String teamName);

}
