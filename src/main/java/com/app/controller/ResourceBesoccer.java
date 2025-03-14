package com.app.controller;

import com.app.models.dto.busquedaTeams.FiltradoTeamsDto;
import com.app.models.dto.competenciasAm.CountryDto;
import com.app.models.response.busquedaTeams.ResponseFiltradoTeams;
import com.app.models.response.top5España.TopTeamsResponseDTO;
import com.app.service.MatchService;
import com.app.service.impl.BusquedaTeamsImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static io.quarkus.arc.impl.UncaughtExceptions.LOGGER;


@Path("/football")
public class ResourceBesoccer {

    @Inject
    MatchService matchService;

    @Inject
    BusquedaTeamsImpl busquedaTeams;

    //AMERICA
    @GET
    @Path("/competenciasContinentes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getCountryMatchs() {
        LOGGER.info("reciviendo de /competenciasContinentes");
        List<CountryDto> countries = matchService.getCountryMatchs();
        LOGGER.info("retorna paises : " + countries);
        return countries;
    }

    //TOP 5 ESPAÑA
    @GET
    @Path("/top5Teams")
    @Produces(MediaType.APPLICATION_JSON)
    public TopTeamsResponseDTO getTopTeams() {
        return matchService.getTopTeams();
    }

    //Busqueda de equipo
    @GET
    @Path("/{leagueId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseFiltradoTeams getTeamsByLeague(@PathParam("leagueId") String leagueId) {
        return busquedaTeams.getTeamsByLeague(leagueId);
    }

    @GET
    @Path("/{leagueId}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchTeamByName(@PathParam("leagueId") String leagueId, @QueryParam("name") String teamName) {
        FiltradoTeamsDto team = busquedaTeams.searchTeamByName(leagueId, teamName);
        return team != null ? Response.ok(team).build() : Response.status(Response.Status.NOT_FOUND).build();
    }
}
