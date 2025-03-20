package com.app.service;

import com.app.models.dto.busquedaTeams.FiltradoTeamsDto;
import com.app.models.response.busquedaTeams.ResponseFiltradoTeams;

public interface SearchLeagueAndTeamService {

    ResponseFiltradoTeams getTeamsByLeague(String leagueId);

    FiltradoTeamsDto searchTeamByName(String leagueId, String teamName);

}
