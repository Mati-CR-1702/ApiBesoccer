package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.configs.LoggerConfig;
import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import com.app.models.response.teamInLeague.FilteredTeamsResponse;
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
public class SearchTeamInLeagueServiceImpl implements SearchTeamInLeagueService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @Inject
    LoggerConfig loggerConfig;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    @ConfigProperty(name = "param.ejer3.besoccer.api.teams.format")
    String format;

    @ConfigProperty(name = "param.ejer3.besoccer.api.teams.requestType")
    String requestType;

    private static final Logger LOGGER = Logger.getLogger(SearchTeamInLeagueServiceImpl.class);

    @Override
    public FilteredTeamsResponse getTeamsForLeague(String leagueId) {

        LOGGER.info(loggerConfig.getTeamsForLeagueMessage() + leagueId);

        var response = besoccerClient.getTeamsForLeague(apiKey, format, requestType, leagueId);

        if (response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn(loggerConfig.getNoTeamsFoundMessage() + leagueId);
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

        LOGGER.info(loggerConfig.getSearchTeamsMessage() + teamName + loggerConfig.getInLeagueMessage() + leagueId);

        return getTeamsForLeague(leagueId).getTeams().stream()
                .filter(team -> team.getNameShow().equalsIgnoreCase(teamName) || team.getFullName().equalsIgnoreCase(teamName))
                .findFirst()
                .orElse(null);
    }


}
