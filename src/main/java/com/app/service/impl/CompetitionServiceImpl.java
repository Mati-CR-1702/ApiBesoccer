package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.competenciasAm.CompetitionFiltradoDTO;
import com.app.models.response.competenciasAm.CompetitionListResponseDTO;
import com.app.service.CompetitionService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class CompetitionServiceImpl implements CompetitionService {

    @Inject
    @RestClient
    BesoccerClient besoccerClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    private static final Logger LOGGER = Logger.getLogger(CompetitionServiceImpl.class);

    @Override
    public CompetitionListResponseDTO getCompetitionsInAmerica() {
        LOGGER.info("Fetching all competitions and filtering only those in America...");

        var response = besoccerClient.getCompetitionsByContinent(apiKey, "Europe%2FMadrid", "categories", "all", "json");

        if (response == null || response.getCompetitions() == null || response.getCompetitions().isEmpty()) {
            LOGGER.warn("No competitions found.");
            return new CompetitionListResponseDTO("America", Collections.emptyList());
        }

        List<CompetitionFiltradoDTO> competitionDToOriginals = response.getCompetitions().stream()
                .filter(comp -> "am".equalsIgnoreCase(comp.continent))
                .map(comp -> new CompetitionFiltradoDTO(
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
}
