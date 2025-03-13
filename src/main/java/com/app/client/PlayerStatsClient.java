package com.app.client;


import com.app.models.response.competenciasAm.ResponseCountry;
import com.app.models.response.top5España.ResponseTop5Espana;
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
public interface PlayerStatsClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackCategories")
    ResponseCountry getCountryMatchs(
            @QueryParam("key") String apiKey,
            @QueryParam("tz") String timezone,
            @QueryParam("format") String format,
            @QueryParam("req") String requestType,
            @QueryParam("filter") String filter
    );

    default ResponseCountry fallbackCategories(String apiKey, String timezone, String requestType, String filter, String format) {
        return new ResponseCountry();
    }
    //TOP 5 DE ESPAÑA JODER
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackTopTeams")
    ResponseTop5Espana getLeagueTable(
            @QueryParam("key") String apiKey,
            @QueryParam("format") String format,
            @QueryParam("req") String requestType,
            @QueryParam("league") String leagueId,
            @QueryParam("group") String group,
            @QueryParam("ext") String ext,
            @QueryParam("type") String type
    );

    default ResponseTop5Espana fallbackTopTeams(String apiKey, String format, String requestType, String leagueId, String group, String ext, String type) {
        return new ResponseTop5Espana();
    }
}
