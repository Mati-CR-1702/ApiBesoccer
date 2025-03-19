package com.app.service;

import com.app.client.BesoccerClient;
import com.app.models.dto.busquedaTeams.FiltradoTeamsDto;
import com.app.models.response.busquedaTeams.ResponseFiltradoTeams;
import com.app.models.response.busquedaTeams.ResponseOriginTeams;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class BusquedaTeamsService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(MatchService.class);


    public ResponseFiltradoTeams getTeamsByLeague(String leagueId) {
        LOGGER.info("buscando equipo " + leagueId);

        ResponseOriginTeams response = besoccerClient.getTeamsByLeague(apiKey, "json",
                "teams", leagueId);

        if (response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn("No se encontro equipo");
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

    public FiltradoTeamsDto searchTeamByName(String leagueId, String teamName) {
        LOGGER.info("buscando para team: " + teamName + " en la liga de " + leagueId);

        return getTeamsByLeague(leagueId).teams.stream()
                .filter(team -> team.nameShow.equalsIgnoreCase(teamName) || team.fullName.equalsIgnoreCase(teamName))
                .findFirst()
                .orElse(null);
    }
}
