package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import com.app.models.response.teamInLeague.FilteredTeamsResponse;
import com.app.models.response.teamInLeague.ResponseOriginTeams;
import com.app.service.SearchTeamInLeagueService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SearchTeamInLeagueInLeagueServiceImpl implements SearchTeamInLeagueService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    @ConfigProperty(name = "param.ejer3.besoccer.api.teams.format")
    String format;

    @ConfigProperty(name = "param.ejer3.besoccer.api.teams.requestType")
    String requestType;

    private static final Logger LOGGER = Logger.getLogger(SearchTeamInLeagueInLeagueServiceImpl.class);

    @Override
    public FilteredTeamsResponse getTeamsByLeague(String leagueId) {
        LOGGER.info("Buscando equipos para la liga: " + leagueId);

        var response = besoccerClient.getTeamsByLeague(apiKey, format, requestType, leagueId);

        if (response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn("No se encontraron equipos para la liga: " + leagueId);
            return new FilteredTeamsResponse("Liga ID: " + leagueId, Collections.emptyList());
        }

        List<FilteredTeamDTO> teamDTOs = response.getTeams().stream()
                .map(team -> new FilteredTeamDTO(
                        team.getId(),
                        team.getNameShow(),
                        team.getGroup_code(),
                        team.getBasealias(),
                        team.getFullName(),
                        team.getShort_name(),
                        team.getCountryCode(),
                        team.getNameShowTeam(),
                        team.getGender()
                ))
                .collect(Collectors.toList());

        return new FilteredTeamsResponse("Liga ID: " + leagueId, teamDTOs);
    }

    @Override
    public FilteredTeamDTO searchTeamByName(String leagueId, String teamName) {

        LOGGER.info("Buscando equipo: " + teamName + " en la liga: " + leagueId);

        return getTeamsByLeague(leagueId).getTeams().stream()
                .filter(team -> team.getNameShow().equalsIgnoreCase(teamName) || team.getFullName().equalsIgnoreCase(teamName))
                .findFirst()
                .orElse(null);
    }


}
