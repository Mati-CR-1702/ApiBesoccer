package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.busquedaTeams.FiltradoTeamsDto;
import com.app.models.response.busquedaTeams.ResponseFiltradoTeams;
import com.app.models.response.busquedaTeams.ResponseOriginTeams;
import com.app.service.SearchLeagueAndTeamService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SearchLeagueAndTeamServiceImpl implements SearchLeagueAndTeamService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(SearchLeagueAndTeamServiceImpl.class);

    @Override
    public ResponseFiltradoTeams getTeamsByLeague(String leagueId) {
        LOGGER.info("Buscando equipos para la liga: " + leagueId);

        ResponseOriginTeams response = besoccerClient.getTeamsByLeague(apiKey, "json", "teams", leagueId);

        if (response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn("No se encontraron equipos para la liga: " + leagueId);
            return new ResponseFiltradoTeams("Liga ID: " + leagueId, Collections.emptyList());
        }

        List<FiltradoTeamsDto> teamDTOs = response.getTeams().stream()
                .map(teams -> new FiltradoTeamsDto(
                        teams.id,
                        teams.nameShow,
                        teams.group_code,
                        teams.basealias,
                        teams.fullName,
                        teams.short_name,
                        teams.countryCode,
                        teams.nameShowTeam,
                        teams.gender
                ))
                .collect(Collectors.toList());

        return new ResponseFiltradoTeams("Liga ID: " + leagueId, teamDTOs);
    }

    @Override
    public FiltradoTeamsDto searchTeamByName(String leagueId, String teamName) {
        LOGGER.info("Buscando equipo: " + teamName + " en la liga: " + leagueId);

        return getTeamsByLeague(leagueId).teams.stream()
                .filter(team -> team.nameShow.equalsIgnoreCase(teamName) || team.fullName.equalsIgnoreCase(teamName))
                .findFirst()
                .orElse(null);
    }


}
