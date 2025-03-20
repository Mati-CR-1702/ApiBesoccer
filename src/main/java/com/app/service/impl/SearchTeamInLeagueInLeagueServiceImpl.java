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

    private static final Logger LOGGER = Logger.getLogger(SearchTeamInLeagueInLeagueServiceImpl.class);

    @Override
    public FilteredTeamsResponse getTeamsByLeague(String leagueId) {
        LOGGER.info("Buscando equipos para la liga: " + leagueId);

        var response = besoccerClient.getTeamsByLeague(apiKey, "json", "teams", leagueId);

        if (response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn("No se encontraron equipos para la liga: " + leagueId);
            return new FilteredTeamsResponse("Liga ID: " + leagueId, Collections.emptyList());
        }

        List<FilteredTeamDTO> teamDTOs = response.getTeams().stream()
                .map(teams -> new FilteredTeamDTO(
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

        return new FilteredTeamsResponse("Liga ID: " + leagueId, teamDTOs);
    }

    @Override
    public FilteredTeamDTO searchTeamByName(String leagueId, String teamName) {
        LOGGER.info("Buscando equipo: " + teamName + " en la liga: " + leagueId);

        return getTeamsByLeague(leagueId).getTeams().stream()
                .filter(team -> team.nameShow.equalsIgnoreCase(teamName) || team.fullName.equalsIgnoreCase(teamName))
                .findFirst()
                .orElse(null);
    }


}
