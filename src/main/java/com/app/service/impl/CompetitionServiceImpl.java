package com.app.service.impl;

import com.app.client.BesoccerClient;
import com.app.models.dto.competitionInAmerica.CompetitionRawDTO;
import com.app.models.response.competitionInAmerica.CompetitionListResponse;
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

    @ConfigProperty(name = "param.ejer1.besoccer.api.timezone")
    String timezone;

    @ConfigProperty(name = "param.ejer1.besoccer.api.requestType")
    String requestType;

    @ConfigProperty(name = "param.ejer1.besoccer.api.filter")
    String filter;

    @ConfigProperty(name = "param.ejer1.besoccer.api.format")
    String format;

    @ConfigProperty(name = "besoccer.api.continent.name")
    String continentName;

    @ConfigProperty(name = "besoccer.api.continent.code")
    String continentCode;

    private static final Logger LOGGER = Logger.getLogger(CompetitionServiceImpl.class);

    @Override
    public CompetitionListResponse getCompetitionsInAmerica() {
        LOGGER.info("Buscando competencias en América...");

        // Llamada al cliente externo para obtener las competencias
        var response = besoccerClient.getCompetitions(apiKey, timezone, requestType, filter, format);

        // Validar si la respuesta es nula o vacía
        if (response == null || response.getCompetitions() == null || response.getCompetitions().isEmpty()) {

            LOGGER.warn("No se encontraron competencias en América.");

            return new CompetitionListResponse(continentName, Collections.emptyList());
        }
        // Filtrar las competencias por continente "am"
        List<CompetitionRawDTO> filteredCompetitions = filterCompetitionsByContinent(response.getCompetitions());
        LOGGER.info("Competencias encontradas: " + filteredCompetitions.size());
        return new CompetitionListResponse(continentName, filteredCompetitions);
    }

    private List<CompetitionRawDTO> filterCompetitionsByContinent(List<CompetitionRawDTO> rawCompetitions) {
        return rawCompetitions.stream()
                .filter(comp -> continentCode.equalsIgnoreCase(comp.getContinent()))
                .collect(Collectors.toList());
    }

}
