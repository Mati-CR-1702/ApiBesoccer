package com.app.service;

import com.app.client.BesoccerClient;
import com.app.models.dto.competenciasAm.CompetitionDToOriginal;
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


        public CompetitionListResponseDTO getCompetitionsInAmerica() {
            LOGGER.info("Fetching all competitions and filtering only those in America...");


            ResponseCompetitions response = besoccerClient.getCompetitionsByContinent(apiKey, "Europe%2FMadrid",
                    "categories", "all","json");


            if (response.getCompetitions() == null || response.getCompetitions().isEmpty()) {
                LOGGER.warn("No competitions found.");
                return new CompetitionListResponseDTO("America", Collections.emptyList());
            }


            List<CompetitionDToOriginal> competitionDToOriginals = response.getCompetitions().stream()
                    .filter(comp -> "am".equalsIgnoreCase(comp.continent))
                    .map(comp -> new CompetitionDToOriginal(
                            comp.id,
                            comp.league_id,
                            comp.name,
                            comp.country,
                            comp.flag,
                            comp.logo_png
                    ))
                    .collect(Collectors.toList());

            return new CompetitionListResponseDTO("America", competitionDToOriginals);
        }



    public TopTeamsResponseDTO getTopTeams() {
        LOGGER.info("Buscando los tops de la liga de españa");
        ResponseTop5Espana response = besoccerClient.getLeagueTable(
                apiKey, "json", "tables", "1", "1", "complete"
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
