package com.app.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

@QuarkusTest
class ResourceBesoccerTest {

        @Test
        void testGetCompetitionsInAmerica() {
            given()
                    .when()
                    .get("/football/competenciasAmerica")
                    .then()
                    .statusCode(200)
                    .body("continent", is("América"))
                    .body("competitions", notNullValue());
        }

        @Test
        void testGetTopTeams() {
            given()
                    .when()
                    .get("/football/top5Teams")
                    .then()
                    .statusCode(200)
                    .body("league", notNullValue())
                    .body("topTeams", notNullValue());
        }

    @Test
    void testGetTeamsByLeague() {
        given()
                .pathParam("leagueId", "Premier League")
                .when()
                .get("/football/{leagueId}")
                .then()
                .statusCode(200)
                .body("league", is("Liga ID: Premier League"))
                .body("teams", notNullValue());
    }

    @Test
    void testSearchTeamByNameFound() {
        given()
                .pathParam("leagueId", "1")
                .queryParam("name", "Barcelona")
                .when()
                .get("/football/{leagueId}/search")
                .then()
                .statusCode(200)
                .body("nameShow", is("Barcelona"));
    }

    @Test
    void testSearchTeamByNameNotFound() {
        given()
                .pathParam("leagueId", "123")
                .queryParam("name", "Unknown Team")
                .when()
                .get("/football/{leagueId}/search")
                .then()
                .statusCode(404);
    }

        @Test
        void testGetCompetitionsWithTeams() {
            given()
                    .when()
                    .get("/football/competitionsWithTeams")
                    .then()
                    .statusCode(200)
                    .body("$", notNullValue());
        }



}