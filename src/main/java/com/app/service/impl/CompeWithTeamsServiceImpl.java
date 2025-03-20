package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.compeWithTeams.CompetitionResponse;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamDTO1;
import com.app.models.dto.compeWithTeams.TeamResponse;
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
        CompetitionResponse competitionResponse = besoccerClient.getCompetitions(
                apiKey, "Europe%2FMadrid", "categories", "my_leagues", "json"
        );

        if (competitionResponse.getCompetitions() == null || competitionResponse.getCompetitions().isEmpty()) {
            LOGGER.warn("No competitions found.");
            return Collections.emptyList();
        }

        List<CompetitionWithTeamsDTO> result = new ArrayList<>();

        // Iterar sobre cada competición y obtener los equipos
        for (var competition : competitionResponse.getCompetitions()) {
            LOGGER.info("Fetching teams for competition: " + competition.name);

            TeamResponse teamResponse = besoccerClient.getTeams(
                    apiKey, "json", "teams", competition.id
            );

            List<TeamDTO1> teams = teamResponse != null && teamResponse.getTeams() != null
                    ? teamResponse.getTeams().stream()
                    .map(team -> new TeamDTO1(
                            team.id,
                            team.nameShow,
                            team.groupCode,
                            team.countryCode,
                            team.shield
                    ))
                    .toList()
                    : Collections.emptyList();

            CompetitionWithTeamsDTO competitionWithTeams = new CompetitionWithTeamsDTO(
                    competition.id,
                    competition.name,
                    competition.country,
                    competition.flag,
                    competition.logo,
                    teams
            );

            result.add(competitionWithTeams);
        }

        return result;
    }
}
