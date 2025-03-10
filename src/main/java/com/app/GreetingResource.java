package com.app;

import com.app.models.Categoria;
import com.app.service.MatchService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@Path("/football")
public class GreetingResource {

    @Inject
    MatchService matchService;

    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> getCategories() {
        return matchService.getCategories();
    }
}
