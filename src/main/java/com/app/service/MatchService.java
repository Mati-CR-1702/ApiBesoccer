package com.app.service;

import com.app.client.PlayerStatsClient;
import com.app.models.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class MatchService {

    @Inject
    @RestClient
    PlayerStatsClient playerStatsClient;

    @ConfigProperty(name = "besoccer.api.key")
    String apiKey;

    public List<Categoria> getCategories() {
        return playerStatsClient.getCategories(apiKey, "Europe/Madrid", "categories", "my_leagues", "json").category;
    }

}
