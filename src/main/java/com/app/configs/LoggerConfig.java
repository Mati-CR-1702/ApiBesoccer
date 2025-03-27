package com.app.configs;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class LoggerConfig {

    public static final String GET_COMPETITIONS_AMERICA_KEY = "log.message.getCompetitionsAmerica";
    public static final String NO_COMPETITIONS_FOUND_KEY = "log.message.noCompetitionsFound";
    public static final String FOUND_COMPETITIONS_KEY = "log.message.foundCompetitions";
    public static final String GET_COMPETITIONS_WITH_TEAMS_KEY = "log.message.getCompetitionsWithTeams";
    public static final String NO_COMPETITIONS_WITH_TEAMS_FOUND_KEY = "log.message.noCompetitionsWithTeamsFound";
    public static final String FOUND_COMPETITIONS_WITH_TEAMS_KEY = "log.message.foundCompetitionsWithTeams";
    public static final String GET_TOP5_SPAIN_KEY = "log.message.getTop5Spain";
    public static final String NO_TOP5_SPAIN_FOUND_KEY = "log.message.noTop5SpainFound";
    public static final String GET_TEAMS_FOR_LEAGUE_KEY = "log.message.getTeamsForLeague";
    public static final String NO_TEAMS_FOUND_KEY = "log.message.noTeamsFound";
    public static final String SEARCH_TEAMS_KEY = "log.message.searchTeams";
    public static final String IN_LEAGUE_KEY = "log.message.inLeague";
    public static final String LEAGUE_ID_KEY = "log.message.leagueId";
    public static final String ERROR_KEY = "log.message.error";
    public static final String UNHANDLED_EXCEPTION_KEY = "log.message.unhandledException";
    public static final String NOT_FOUND_KEY = "log.message.notFound";
    public static final String DEV_UI_EXCEPTION_KEY = "log.message.devUiException";

    @ConfigProperty(name = GET_COMPETITIONS_AMERICA_KEY)
    String getCompetitionsAmerica;

    @ConfigProperty(name = NO_COMPETITIONS_FOUND_KEY)
    String noCompetitionsFound;

    @ConfigProperty(name = FOUND_COMPETITIONS_KEY)
    String foundCompetitions;

    @ConfigProperty(name = GET_COMPETITIONS_WITH_TEAMS_KEY)
    String getCompetitionsWithTeams;

    @ConfigProperty(name = NO_COMPETITIONS_WITH_TEAMS_FOUND_KEY)
    String noCompetitionsWithTeamsFound;

    @ConfigProperty(name = FOUND_COMPETITIONS_WITH_TEAMS_KEY)
    String foundCompetitionsWithTeams;

    @ConfigProperty(name = GET_TOP5_SPAIN_KEY)
    String getTop5Spain;

    @ConfigProperty(name = NO_TOP5_SPAIN_FOUND_KEY)
    String noTop5SpainFound;

    @ConfigProperty(name = GET_TEAMS_FOR_LEAGUE_KEY)
    String getTeamsForLeague;

    @ConfigProperty(name = NO_TEAMS_FOUND_KEY)
    String noTeamsFound;

    @ConfigProperty(name = SEARCH_TEAMS_KEY)
    String searchTeams;

    @ConfigProperty(name = IN_LEAGUE_KEY)
    String inLeague;

    @ConfigProperty(name = LEAGUE_ID_KEY)
    String leagueId;

    @ConfigProperty(name = ERROR_KEY)
    String error;

    @ConfigProperty(name = UNHANDLED_EXCEPTION_KEY)
    String unhandledException;

    @ConfigProperty(name = NOT_FOUND_KEY)
    String notFound;

    @ConfigProperty(name = DEV_UI_EXCEPTION_KEY)
    String devUiException;

    public String getCompetitionsAmericaMessage() {
        return getCompetitionsAmerica;
    }

    public String getNoCompetitionsFoundMessage() {
        return noCompetitionsFound;
    }

    public String getFoundCompetitionsMessage(int count) {
        return foundCompetitions.replace("{0}", String.valueOf(count));
    }

    public String getCompetitionsWithTeamsMessage() {
        return getCompetitionsWithTeams;
    }

    public String getNoCompetitionsWithTeamsFoundMessage() {
        return noCompetitionsWithTeamsFound;
    }

    public String getFoundCompetitionsWithTeamsMessage() {
        return foundCompetitionsWithTeams;
    }

    public String getTop5SpainMessage() {
        return getTop5Spain;
    }

    public String getNoTop5SpainFoundMessage() {
        return noTop5SpainFound;
    }

    public String getTeamsForLeagueMessage() {
        return getTeamsForLeague;
    }

    public String getNoTeamsFoundMessage() {
        return noTeamsFound;
    }

    public String getSearchTeamsMessage() {
        return searchTeams;
    }

    public String getInLeagueMessage() {
        return inLeague;
    }

    public String getLeagueIdMessage() {
        return leagueId;
    }

    public String getErrorMessage() {
        return error;
    }

    public String getUnhandledExceptionMessage() {
        return unhandledException;
    }

    public String getNotFoundMessage() {
        return notFound;
    }

    public String getDevUiExceptionMessage() {
        return devUiException;
    }
}