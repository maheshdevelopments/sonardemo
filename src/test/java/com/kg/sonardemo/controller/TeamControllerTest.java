package com.kg.sonardemo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.kg.sonardemo.entity.Team;
import com.kg.sonardemo.service.TeamService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * TeamController
 */

@RunWith(MockitoJUnitRunner.class)

public class TeamControllerTest {

  @Mock
  private TeamService teamService;
  
  @InjectMocks
  private TeamController teamController;

  public static List<Team> expected;
  Team team1 = new TeamBuilder().id(1).name("mahesh").build();
  Team team2 = new TeamBuilder().id(2).name("aravinth").build();

  @Test
  public void allTest() {
    expected = Arrays.asList(team1, team2);
    System.out.println(expected);
    when(teamService.getTeams()).thenReturn(expected);
    ResponseEntity<List<Team>> actual = teamController.all();
    assertNotNull(actual);
    assertEquals(expected, actual.getBody());
    assertEquals(HttpStatus.OK, actual.getStatusCode());
  }
}