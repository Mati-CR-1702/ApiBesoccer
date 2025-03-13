package com.app.service;

import com.app.client.PlayerStatsClient;
import com.app.models.dto.competenciasAm.DtoCountry;
import com.app.models.dto.top5España.TeamDTO;
import com.app.models.response.competenciasAm.ResponseCountry;
import com.app.models.response.top5España.ResponseTop5Espana;
import com.app.models.response.top5España.TopTeamsResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class MatchService {

    @Inject
    @RestClient
    PlayerStatsClient playerStatsClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(MatchService.class);

    // Americaaa

    public List<DtoCountry> getCountryMatchs() {
        LOGGER.info("llamando getCountryMatchs con la API key: " + apiKey);
        ResponseCountry response = playerStatsClient.getCountryMatchs(apiKey, "America%2FChile", "json",
                "countries_competitions", "am");
        List<DtoCountry> countries = response.getCountries();
        LOGGER.info("Reciviendo paises: " + countries);
        return countries;
    }

    // TOP 5 DE ESPAÑA JODER

    public TopTeamsResponseDTO getTopTeams() {
        LOGGER.info("Buscando los tops de la liga de españa");
        ResponseTop5Espana response = playerStatsClient.getLeagueTable(
                apiKey, "json", "tables", "1", "1", "png", "complete"
        );
        if (response.getTeams() == null || response.getTeams().isEmpty()) {
            LOGGER.warn("No se encuentra nadaaaaaa");
            return new TopTeamsResponseDTO("La Liga", Collections.emptyList());
        }
        List<TeamDTO> teamDTOs = response.getTeams().stream()
                .limit(5)
                .map(team -> new TeamDTO(
                        team.id,
                        team.group,
                        team.groupName,
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

        return new TopTeamsResponseDTO("La Liga", teamDTOs);
    }
}
