package com.app.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class ResourceBesoccerTest {


    @Test
    void testGetCompetitionsInAmerica() {
        given()
                .when().get("/football/competenciasAmerica")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    void testGetTopTeams() {
        given()
                .when().get("/football/top5Teams")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

    @Test
    void testGetTeamsByLeague() {
        String leagueId = "123";
        given()
                .pathParam("leagueId", leagueId)
                .when().get("/football/{leagueId}")
                .then()
                .statusCode(200)
                .body(notNullValue());
    }

}