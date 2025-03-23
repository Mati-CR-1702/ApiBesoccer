package com.app.route;

import com.app.service.CompeWithTeamsService;
import com.app.service.CompetitionService;
import com.app.service.SearchTeamInLeagueService;
import com.app.service.Top5SpainService;
import org.apache.camel.builder.RouteBuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class BesoccerRoutes extends RouteBuilder {


    @Inject
    CompetitionService competitionService;

    @Inject
    Top5SpainService top5SpainService;

    @Inject
    CompeWithTeamsService compeWithTeamsService;

    @Inject
    SearchTeamInLeagueService searchTeamInLeagueService;

    @Override
    public void configure() throws Exception {

        from("direct:getCompetitionsInAmerica")
                .log("solicitud de competencias en America")
                .bean(competitionService, "getCompetitionsInAmerica")
                .log("Competencias obtenidas: ${body}");


        from("direct:getTopTeams")
                .log("buscando top 5 equipos")
                .bean(top5SpainService, "getTop5Teams")
                .log("Response: ${body}");

        from("direct:getTeamsByLeague")
                .log("buscando equipos de la liga: ${header.leagueId}")
                .process(exchange -> {
                    String leagueId = exchange.getIn().getHeader("leagueId", String.class);
                    exchange.getIn().setBody(searchTeamInLeagueService.getTeamsForLeague(leagueId));
                })
                .log("Response: ${body}");

        from("direct:getCompetitionsWithTeams")
                .log("buscando competiciones con sus equipos")
                .bean(compeWithTeamsService, "getCompetitionsWithTeams")
                .log("Response: ${body}");
    }
}