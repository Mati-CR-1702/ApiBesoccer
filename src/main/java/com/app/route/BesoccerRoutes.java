package com.app.route;

import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.service.CompeWithTeamsService;
import com.app.service.CompetitionService;
import com.app.service.SearchTeamInLeagueService;
import com.app.service.Top5SpainService;
import org.apache.camel.builder.RouteBuilder;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

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
                .log("Iniciando proceso para obtener competiciones con sus equipos")
                .bean(compeWithTeamsService, "getCompetitions")
                .log("Competiciones obtenidas: ${body}")
                .split(body())
                .parallelProcessing()
                .bean(compeWithTeamsService, "getTeamsForCompetition")
                .end()
                .process(exchange -> {
                    List<CompetitionWithTeamsDTO> competitionsWithTeams = exchange.getIn().getBody(List.class);
                    exchange.getIn().setBody(competitionsWithTeams);
                })
                .log("Proceso completado. Respuesta final: ${body}");
    }
}