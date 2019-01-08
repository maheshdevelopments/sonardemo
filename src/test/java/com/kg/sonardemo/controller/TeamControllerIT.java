package com.kg.sonardemo.controller;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.kg.sonardemo.SonardemoApplication;
import com.kg.sonardemo.entity.Team;
import com.kg.sonardemo.repository.TeamRepository;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.RestAssured.given;

/**
 * TeamControllerIT
 */
@RunWith(SpringRunner.class)

@SpringBootTest(classes = SonardemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")

public class TeamControllerIT {
    private static final String GET_POST = "api/teams/";
    private static final String PUT = "api/teams/{id}";
    private static final String DELETE = "api/teams/{id}";
    private static final String NAME_FIELD = "teamname";
    private static final String name = "mahesh";
    public Team team1 = new TeamBuilder().id(1L).name("mahesh").build();
    public Team team2 = new TeamBuilder().id(2L).name("aravinth").build();
    public Team team3 = new TeamBuilder().id(1L).name("shanmugam").build();
    @Value("${local.server.port}")
    private int serverPort;
    @Autowired
    private TeamRepository teamRepository;
    private Team firstTeam;
    private Team secondTeam;

    @Before
    public void setUp() {
        teamRepository.deleteAll();
        firstTeam = teamRepository.save(team1);
        secondTeam = teamRepository.save(team2);
        RestAssured.port = serverPort;
    }

    @Test
    public void addTeamIT() {
        given().body(team3).contentType(ContentType.JSON).when().post(GET_POST).then()
                .statusCode(HttpStatus.SC_CREATED);
        System.out.println("Add method executed");
    }

    @Test
    public void allTestIT() {
        when().get(GET_POST).then().body(NAME_FIELD, hasItem(name));
        System.out.println("Get all method executed");
    }

    @Test
    public void updateTestIT() {
        given().body(team3).contentType(ContentType.JSON).when().put(PUT, firstTeam.getTeamid()).then()
                .statusCode(HttpStatus.SC_OK).body(NAME_FIELD, is(team3.getTeamname()));
        System.out.println("Update method executed");
    }

    @Test
    public void deleteTestIT() {
        when().delete(DELETE, secondTeam.getTeamid()).then().statusCode(HttpStatus.SC_NO_CONTENT);
        System.out.println("Delete method executed");
    }
}