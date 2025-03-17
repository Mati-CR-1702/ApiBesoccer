package com.app.service;

import com.app.client.BesoccerClient;
import com.app.models.dto.competenciasAm.CompetitionDTO;
import com.app.models.dto.top5España.TeamDTO;
import com.app.models.response.competenciasAm.CompetitionListResponseDTO;
import com.app.models.response.competenciasAm.ResponseCompetitions;
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
    BesoccerClient besoccerClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(MatchService.class);

    // Americaaa
        public CompetitionListResponseDTO getCompetitionsInAmerica() {
            LOGGER.info("Fetching all competitions and filtering only those in America...");

            // Obtiene todas las competiciones
            ResponseCompetitions response = besoccerClient.getCompetitionsByContinent(apiKey, "Europe%2FMadrid",
                    "categories", "all","json");

            // Verificamos si la respuesta está vacía
            if (response.getCompetitions() == null || response.getCompetitions().isEmpty()) {
                LOGGER.warn("No competitions found.");
                return new CompetitionListResponseDTO("America", Collections.emptyList());
            }

            // Filtramos solo las competiciones de América usando
            List<CompetitionDTO> competitionDTOs = response.getCompetitions().stream()
                    .filter(comp -> "am".equalsIgnoreCase(comp.continent)) // Solo competiciones en América
                    .map(comp -> new CompetitionDTO(
                            comp.id,
                            comp.league_id,
                            comp.shortName,
                            comp.name,
                            comp.country,
                            comp.flag,
                            comp.logo_png
                    ))
                    .collect(Collectors.toList());

            return new CompetitionListResponseDTO("America", competitionDTOs);
        }

    // TOP 5 DE ESPAÑA JODER

    public TopTeamsResponseDTO getTopTeams() {
        LOGGER.info("Buscando los tops de la liga de españa");
        ResponseTop5Espana response = besoccerClient.getLeagueTable(
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
