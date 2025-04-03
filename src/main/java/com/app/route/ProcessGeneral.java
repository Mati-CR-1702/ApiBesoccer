package com.app.route;


import com.app.models.dto.compeWithTeams.CompetitionWithTeamsDTO;
import com.app.service.SearchTeamInLeagueService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

@ApplicationScoped
public class ProcessGeneral implements Processor {

    @Inject
    SearchTeamInLeagueService searchTeamInLeagueService;

    @Override
    public void process(Exchange exchange) throws Exception {

    }


    public void processTeamsByLeague(Exchange exchange) throws Exception {
        String leagueId = exchange.getIn().getHeader("leagueId", String.class);
        if (leagueId == null || leagueId.isEmpty()) {
            throw new IllegalArgumentException("el header/param 'leagueId' es obligatorio");
        }
        exchange.getIn().setBody(searchTeamInLeagueService.getTeamsForLeague(leagueId));
    }


    public void processCompetitionsWithTeams(Exchange exchange) throws Exception {
        List<CompetitionWithTeamsDTO> competitionsWithTeams = exchange.getIn().getBody(List.class);
        exchange.getIn().setBody(competitionsWithTeams);
    }
}
