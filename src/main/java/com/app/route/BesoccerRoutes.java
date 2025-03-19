package com.app.route;

import org.apache.camel.builder.RouteBuilder;

import com.app.service.MatchService;
import com.app.service.BusquedaTeamsService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BesoccerRoutes extends RouteBuilder {


    @Inject
    MatchService matchService;

    @Inject
    BusquedaTeamsService busquedaTeams;

    @Override
    public void configure() throws Exception {

        from("direct:getCompetitionsInAmerica")
            .log("Fetching competitions in America...")
            .bean(matchService, "getCompetitionsInAmerica")
            .log("Response: ${body}");

        from("direct:getTopTeams")
            .log("Fetching top 5 teams...")
            .bean(matchService, "getTopTeams")
            .log("Response: ${body}");

        from("direct:getTeamsByLeague")
            .log("Fetching teams for league: ${header.leagueId}")
            .process(exchange -> {
                String leagueId = exchange.getIn().getHeader("leagueId", String.class);
                exchange.getIn().setBody(busquedaTeams.getTeamsByLeague(leagueId));
            })            
            .log("Response: ${body}");
    }
}