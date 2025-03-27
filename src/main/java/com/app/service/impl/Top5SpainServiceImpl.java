package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.configs.LoggerConfig;
import com.app.models.dto.top5Spain.ClassificationFiltradoDTO;
import com.app.models.response.top5Spain.Top5TeamsResponse;
import com.app.service.Top5SpainService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class Top5SpainServiceImpl implements Top5SpainService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @Inject
    LoggerConfig loggerConfig;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    @ConfigProperty(name = "param.ejer2.besoccer.api.laliga.name")
    String leagueName;

    @ConfigProperty(name = "param.ejer2.besoccer.api.laliga.leagueId")
    String leagueId;

    @ConfigProperty(name = "param.ejer2.besoccer.api.laliga.group")
    String group;

    @ConfigProperty(name = "param.ejer2.besoccer.api.laliga.type")
    String type;

    @ConfigProperty(name = "param.ejer2.besoccer.api.laliga.format")
    String format;

    @ConfigProperty(name = "param.ejer2.besoccer.api.laliga.requestType")
    String requestType;

    private static final Logger LOGGER = Logger.getLogger(Top5SpainServiceImpl.class);

        @Override
        public Top5TeamsResponse getTop5Teams() {
            LOGGER.info(loggerConfig.getTop5SpainMessage()+ leagueName);

            var response = besoccerClient.getClasificaciones(
                    apiKey, format, requestType, leagueId, group, type
            );

            if (response == null || response.getTeams() == null || response.getTeams().isEmpty()) {
                LOGGER.warn(loggerConfig.getNoTop5SpainFoundMessage()+ leagueName);
                return new Top5TeamsResponse(leagueName, Collections.emptyList());
            }

            List<ClassificationFiltradoDTO> top5Teams = response.getTeams().stream()
                    .limit(5)
                    .map(team -> new ClassificationFiltradoDTO(
                            team.getId(),
                            team.getGroup(),
                            team.getTeam(),
                            team.getPoints(),
                            team.getWins(),
                            team.getDraws(),
                            team.getLosses(),
                            team.getGf(),
                            team.getGa(),
                            team.getAvg(),
                            team.getAbbr(),
                            team.getPos()
                    ))
                    .collect(Collectors.toList());

            return new Top5TeamsResponse(leagueName, top5Teams);
        }
}

