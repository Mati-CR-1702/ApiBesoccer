package com.app.controller;

import com.app.models.dto.teamInLeague.FilteredTeamDTO;
import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.models.response.teamInLeague.FilteredTeamsResponse;
import com.app.models.response.competitionInAmerica.CompetitionListResponse;
import com.app.models.response.top5Spain.Top5TeamsResponse;
import com.app.service.SearchTeamInLeagueService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.apache.camel.CamelContext;

import java.util.List;


@Path("/v1/football")
public class ResourceBesoccer {

    @Inject
    SearchTeamInLeagueService searchTeamInLeagueService;


    @Inject
    CamelContext camelContext;

    @GET
    @Path("/competenciasAmerica")
    @Produces(MediaType.APPLICATION_JSON)
    public CompetitionListResponse getCompetitionsInAmerica() throws Exception {
        return camelContext.createProducerTemplate()
                .requestBody("direct:getCompetitionsInAmerica", null, CompetitionListResponse.class);
    }

    @GET
    @Path("/top5Teams")
    @Produces(MediaType.APPLICATION_JSON)
    public Top5TeamsResponse getTopTeams() throws Exception {
        return camelContext.createProducerTemplate()
                .requestBody("direct:getTopTeams", null, Top5TeamsResponse.class);
    }

    @GET
    @Path("/{leagueId}")
    @Produces(MediaType.APPLICATION_JSON)
    public FilteredTeamsResponse getTeamsByLeague(@PathParam("leagueId") String leagueId) throws Exception {
        return camelContext.createProducerTemplate()
                .requestBodyAndHeader("direct:getTeamsByLeague", null, "leagueId", leagueId, FilteredTeamsResponse.class);
    }

    @GET
    @Path("/{leagueId}/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchTeamByName(@PathParam("leagueId") String leagueId, @QueryParam("name") String teamName) {
        FilteredTeamDTO team = searchTeamInLeagueService.searchTeamByName(leagueId, teamName);
        return team != null ? Response.ok(team).build() : Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/competitionsWithTeams")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CompetitionWithTeamsDTO> getCompetitionsWithTeams() throws Exception {
        return camelContext.createProducerTemplate()
                .requestBody("direct:getCompetitionsWithTeams", null, List.class);
    }

}
