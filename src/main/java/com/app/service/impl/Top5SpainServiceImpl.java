package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.top5España.TeamFiltradoDTO;
import com.app.models.response.top5España.TopTeamsResponseDTO;
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

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(Top5SpainServiceImpl.class);

    @Override
    public TopTeamsResponseDTO getTop5Teams() {
        LOGGER.info("Buscando los tops de la liga de españa");

        var response = besoccerClient.getLeagueTable(
                apiKey, "json", "tables", "1", "1", "complete"
        );

        if (response == null || response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn("No se encuentra nadaaaaaa");
            return new TopTeamsResponseDTO("La Liga", Collections.emptyList());
        }

        List<TeamFiltradoDTO> teamFiltradoDTOS = response.getTeams().stream()
                .limit(5)
                .map(team -> new TeamFiltradoDTO(
                        team.id,
                        team.group,
                        team.team,
                        team.points,
                        team.wins,
                        team.draws,
                        team.losses,
                        team.gf,
                        team.ga,
                        team.avg,
                        team.abbr,
                        team.pos
                ))
                .collect(Collectors.toList());

        return new TopTeamsResponseDTO("La Liga", teamFiltradoDTOS);
    }

}
