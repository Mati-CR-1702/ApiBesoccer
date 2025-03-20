package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import com.app.models.response.compeWithTeams.CompetitionWithTeamsResponse;
import com.app.service.CompeWithTeamsService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

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
        LOGGER.info("Buscando competencias y equipos.");


        var response = besoccerClient.getCompetitions (
                apiKey, "Europe%2FMadrid", "categories", "my_leagues", "json"
        );

        if (response.getCompetitions() == null || response.getCompetitions().isEmpty()) {
            LOGGER.warn("No se encontraron competencias.");
            return Collections.emptyList();
        }

        List<CompetitionWithTeamsDTO> result = response.getCompetitions().stream()
                .map(competition -> {
                    LOGGER.info("Ahora buscando equipos de : " + competition.name);

                    CompetitionWithTeamsResponse competitionWithTeamsResponse = besoccerClient.getCompetitionWithTeams(apiKey, "json", "teams", competition.id);
                    List<TeamWithCompetitionDTO> teams = competitionWithTeamsResponse != null && competitionWithTeamsResponse.getTeams() != null
                                ? competitionWithTeamsResponse.getTeams().stream()
                            .map(team -> new TeamWithCompetitionDTO(
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
