package com.app.configs;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class LoggerConfig {

    @ConfigProperty(name = "log.message.getCompetitionsAmerica", defaultValue = "Buscando competencias en America")
    String getCompetitionsAmerica;

    @ConfigProperty(name = "log.message.noCompetitionsFound", defaultValue = "No se encontraron competencias en America.")
    String noCompetitionsFound;

    @ConfigProperty(name = "log.message.foundCompetitions", defaultValue = "Competencias encontradas: {0}")
    String foundCompetitions;

    //LOGS PARA CompeWithTeamsServiceImpl

    @ConfigProperty(name = "log.message.getCompetitionsWithTeams", defaultValue = "Buscando competiciones con sus equipos")
    String getCompetitionsWithTeams;

    public String getCompetitionsAmerica() {
        return getCompetitionsAmerica;
    }

    public String noCompetitionsFound() {
        return noCompetitionsFound;
    }

    public String foundCompetitions(int count) {
        return foundCompetitions.replace("{0}", String.valueOf(count));
    }
}
