package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.configs.LoggerConfig;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamWithCompetitionDTO;
import com.app.models.response.compeWithTeams.CompetitionWithTeamsResponse;
import com.app.service.CompeWithTeamsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CompeWithTeamsServiceImpl implements CompeWithTeamsService {

        @Inject
        @RestClient
        BesoccerClient besoccerClient;

        @Inject
        LoggerConfig loggerConfig;

        @ConfigProperty(name = "besoccer.api.key")
        String apiKey;

        @ConfigProperty(name = "param.ejer4.besoccer.api.competitions.requestType")
        String competitionsRequestType;

        @ConfigProperty(name = "param.ejer4.besoccer.api.competitions.filter")
        String competitionsFilter;

        @ConfigProperty(name = "param.ejer4.besoccer.api.timezone")
        String competitionsTimezone;

        @ConfigProperty(name = "param.ejer4.besoccer.api.competitions.format")
        String competitionsFormat;

        @ConfigProperty(name = "param.ejer4.besoccer.api.teams.requestType")
        String teamsRequestType;

        @ConfigProperty(name = "param.ejer4.besoccer.api.teams.format")
        String teamsFormat;

        private static final Logger LOGGER = Logger.getLogger(CompeWithTeamsServiceImpl.class);

        public List<CompetitionWithTeamsDTO> getCompetitions() {
            LOGGER.info(loggerConfig.getCompetitionsWithTeamsMessage());

            var competitionsResponse = besoccerClient.getCompetitions(
                    apiKey, competitionsTimezone, competitionsRequestType, competitionsFilter, competitionsFormat
            );

            if (competitionsResponse.getCompetitions() == null || competitionsResponse.getCompetitions().isEmpty()) {
                LOGGER.warn(loggerConfig.getNoCompetitionsWithTeamsFoundMessage());
                return Collections.emptyList();
            }

            return competitionsResponse.getCompetitions().stream()
                    .map(competition -> new CompetitionWithTeamsDTO(
                            competition.getId(),
                            competition.getName(),
                            competition.getCountry(),
                            competition.getLogo_png(),
                            competition.getFlag(),
                            Collections.emptyList()
                    ))
                    .collect(Collectors.toList());
        }

        public CompetitionWithTeamsDTO getTeamsForCompetition(CompetitionWithTeamsDTO competition) {
            LOGGER.info(loggerConfig.getFoundCompetitionsWithTeamsMessage() + competition.getCompetitionName());

            CompetitionWithTeamsResponse competitionWithTeamsResponse = besoccerClient.getTeamForCompetition(
                    apiKey, teamsFormat, teamsRequestType, competition.getCompetitionId()
            );

            List<TeamWithCompetitionDTO> teams = competitionWithTeamsResponse != null && competitionWithTeamsResponse.getTeams() != null
                    ? competitionWithTeamsResponse.getTeams()
                    : Collections.emptyList();

            competition.setTeams(teams);
            return competition;
        }
}

