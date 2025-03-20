package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamWithTeamDTO;
import com.app.models.response.compeWithTeams.TeamResponse;
import com.app.service.CompeWithTeamsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class CompeWithTeamsServiceImpl implements CompeWithTeamsService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(CompeWithTeamsServiceImpl.class);

    @Override
    public List<CompetitionWithTeamsDTO> getCompetitionsWithTeams() {
        LOGGER.info("Fetching competitions and their teams...");

        // Obtener competiciones
        var response = besoccerClient.getCompetitions (
                apiKey, "Europe%2FMadrid", "categories", "my_leagues", "json"
        );

        if (response.getCompetitions() == null || response.getCompetitions().isEmpty()) {
            LOGGER.warn("No competitions found.");
            return Collections.emptyList();
        }

        List<CompetitionWithTeamsDTO> result = response.getCompetitions().stream()
                .map(competition -> {
                    LOGGER.info("Fetching teams for competition: " + competition.name);
                    TeamResponse teamResponse = besoccerClient.getTeams(apiKey, "json", "teams", competition.id);
                    List<TeamWithTeamDTO> teams = teamResponse != null && teamResponse.getTeams() != null
                            ? teamResponse.getTeams().stream()
                            .map(team -> new TeamWithTeamDTO(
                                    team.id,
                                    team.nameShow,
                                    team.groupCode,
                                    team.countryCode,
                                    team.shield
                            ))
                            .toList()
                            : Collections.emptyList();
                    return new CompetitionWithTeamsDTO(
                            competition.id,
                            competition.name,
                            competition.country,
                            competition.flag,
                            competition.logo_png,
                            teams
                    );
                })
                .toList();

        return result;
    }
}
