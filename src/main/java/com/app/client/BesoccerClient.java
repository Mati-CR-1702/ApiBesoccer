package com.app.client;


import com.app.models.response.compeWithTeams.TeamResponse;
import com.app.models.response.busquedaTeams.ResponseOriginTeams;
import com.app.models.response.competenciasAm.ResponseCompetitions;
import com.app.models.response.top5España.LeagueTableResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "besoccer-api")
@Path("/scripts/api/api.php")
public interface BesoccerClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackCategories")
    ResponseCompetitions getCompetitions(
            @QueryParam("key") String apiKey,
            @QueryParam("tz") String timezone,
            @QueryParam("req") String requestType,
            @QueryParam("filter") String filter,
            @QueryParam("format") String format
    );

    default ResponseCompetitions fallbackCategories(String apiKey, String timezone, String requestType, String filter, String format) {
        return new ResponseCompetitions();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackTopTeams")
    LeagueTableResponse getLeagueTable(
            @QueryParam("key") String apiKey,
            @QueryParam("format") String format,
            @QueryParam("req") String requestType,
            @QueryParam("league") String leagueId,
            @QueryParam("group") String group,
            @QueryParam("type") String type
    );

    default LeagueTableResponse fallbackTopTeams(String apiKey, String format, String requestType, String leagueId, String group, String type) {
        return new LeagueTableResponse();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackTeams")
    ResponseOriginTeams getTeamsByLeague(
            @QueryParam("key") String apiKey,
            @QueryParam("format") String format,
            @QueryParam("req") String requestType,
            @QueryParam("league") String leagueId
    );

    default ResponseOriginTeams fallbackTeams(String apiKey, String format, String requestType, String leagueId) {
        return new ResponseOriginTeams();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackTeams2")
    TeamResponse getTeams(
            @QueryParam("key") String apiKey,
            @QueryParam("format") String format,
            @QueryParam("req") String requestType,
            @QueryParam("league") String leagueId
    );

    default TeamResponse fallbackTeams2(String apiKey, String format, String requestType, String leagueId) {
        return new TeamResponse();
    }

}
