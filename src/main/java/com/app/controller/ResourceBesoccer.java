package com.app.controller;

import com.app.models.dto.competenciasAm.DtoCountry;
import com.app.models.response.top5España.TopTeamsResponseDTO;
import com.app.service.MatchService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static io.quarkus.arc.impl.UncaughtExceptions.LOGGER;


@Path("/football")
public class ResourceBesoccer {

    @Inject
    MatchService matchService;
    //AMERICA
    @GET
    @Path("/competenciasContinentes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DtoCountry> getCountryMatchs() {
        LOGGER.info("Received request for /competenciasContinentes");
        List<DtoCountry> countries = matchService.getCountryMatchs();
        LOGGER.info("Returning countries: " + countries);
        return countries;
    }

    //TOP 5 ESPAÑA
    @GET
    @Path("/top5Teams")
    @Produces(MediaType.APPLICATION_JSON)
    public TopTeamsResponseDTO getTopTeams() {
        return matchService.getTopTeams();
    }


}
