package com.app.client;


import com.app.models.Categoria;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(configKey = "besoccer-api")
@Path("/scripts/api/api.php")
public interface PlayerStatsClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 1000)
    @Fallback(fallbackMethod = "fallbackCategories")
    ResponseWrapper getCategories(
            @QueryParam("key") String apiKey,
            @QueryParam("tz") String timezone,
            @QueryParam("req") String requestType,
            @QueryParam("filter") String filter,
            @QueryParam("format") String format
    );

    class ResponseWrapper {
        public List<Categoria> category;
    }

    default ResponseWrapper fallbackCategories(String apiKey, String timezone, String requestType, String filter, String format) {
        return new ResponseWrapper();
    }

}
