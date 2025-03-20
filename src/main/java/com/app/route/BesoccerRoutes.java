package com.app.route;

import com.app.service.CompetitionService;
import com.app.service.SearchLeagueAndTeamService;
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
    SearchLeagueAndTeamService searchLeagueAndTeamService;

    @Override
    public void configure() throws Exception {

        from("direct:getCompetitionsInAmerica")
                .log("Buscando competiciones en america.")
                .bean(competitionService, "getCompetitionsInAmerica")
                .log("Response: ${body}");

        from("direct:getTopTeams")
                .log("Buscando el top 5. ")
                .bean(top5SpainService, "getTop5Teams")
                .log("Response: ${body}");

        from("direct:getTeamsByLeague")
                .log("Buscando equipo de la liga: ${header.leagueId}")
                .process(exchange -> {
                    String leagueId = exchange.getIn().getHeader("leagueId", String.class);
                    exchange.getIn().setBody(searchLeagueAndTeamService.getTeamsByLeague(leagueId));
                })
                .log("Response: ${body}");
    }
}