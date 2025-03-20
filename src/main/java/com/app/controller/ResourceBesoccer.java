package com.app.controller;

import com.app.models.dto.busquedaTeams.FiltradoTeamsDto;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.dto.compeWithTeams.TeamDTO1;
import com.app.models.response.busquedaTeams.ResponseFiltradoTeams;
import com.app.models.response.competenciasAm.CompetitionListResponseDTO;
import com.app.models.response.top5España.TopTeamsResponseDTO;
import com.app.service.CompeWithTeamsService;
import com.app.service.SearchLeagueAndTeamService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.apache.camel.CamelContext;

import java.util.List;


@Path("/football")
public class ResourceBesoccer {

    @Inject
    SearchLeagueAndTeamService searchLeagueAndTeamService;

    @Inject
    CompeWithTeamsService compeWithTeamsService;

    @Inject
    CamelContext camelContext;


    @GET
    @Path("/competenciasAmerica")
    @Produces(MediaType.APPLICATION_JSON)
    public CompetitionListResponseDTO getCompetitionsInAmerica() throws Exception {
        return camelContext.createProducerTemplate()
            .requestBody("direct:getCompetitionsInAmerica", null, CompetitionListResponseDTO.class);
}


    @GET
    @Path("/top5Teams")
    @Produces(MediaType.APPLICATION_JSON)
    public TopTeamsResponseDTO getTopTeams() throws Exception {
        return camelContext.createProducerTemplate()
                .requestBody("direct:getTopTeams", null, TopTeamsResponseDTO.class);
    }


    @GET
    @Path("/{leagueId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseFiltradoTeams getTeamsByLeague(@PathParam("leagueId") String leagueId) throws Exception {
        return camelContext.createProducerTemplate()
                .requestBodyAndHeader("direct:getTeamsByLeague", null, "leagueId", leagueId, ResponseFiltradoTeams.class);
    }

    @GET
    @Path("/{leagueId}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchTeamByName(@PathParam("leagueId") String leagueId, @QueryParam("name") String teamName) {
        FiltradoTeamsDto team = searchLeagueAndTeamService.searchTeamByName(leagueId, teamName);
        return team != null ? Response.ok(team).build() : Response.status(Response.Status.NOT_FOUND).build();
    }
    @GET
    @Path("/competitions-with-teams")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompetitionWithTeamsDTO> getCompetitionsWithTeams() {
        return compeWithTeamsService.getCompetitionsWithTeams();
    }

}
