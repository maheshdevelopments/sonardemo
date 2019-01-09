package com.kg.sonardemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kg.sonardemo.entity.Team;
import com.kg.sonardemo.service.TeamService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

/**
 * TeamControllerMockMVCIT
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TeamController.class, secure = false)
public class TeamControllerMockMVCIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;
    private static final String GET_POST = "api/teams/";
    private static final String PUT = "api/teams/{id}";
    private static final String DELETE = "api/teams/{id}";
    public Team team1 = new TeamBuilder().id(1L).name("mahesh").build();
    public Team team2 = new TeamBuilder().id(2L).name("aravinth").build();

    @Test
    public void getAll() throws Exception {
        List<Team> alist1 = new ArrayList<Team>();
        alist1.add(team1);
        given(teamService.getTeams()).willReturn(alist1);
        mockMvc.perform(get(GET_POST).accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());
        System.out.println("Get all method executed");
    }

    @Test
    public void getByID() throws Exception {
        List<Team> alist = new ArrayList<Team>();
        alist.add(team1);
        given(teamService.findByTeamId(team1.getTeamid())).willReturn(team1);
        mockMvc.perform(get("/api/teams/1").accept(MediaType.APPLICATION_JSON));
        System.out.println("Get Id method executed");
    }

    @Test
    public void postmapping() throws Exception {
        List<Team> alist1 = new ArrayList<Team>();
        alist1.add(team1);
        when(teamService.findByTeamId(team1.getTeamid())).thenReturn(team1);
        mockMvc.perform(post(GET_POST).contentType(MediaType.APPLICATION_JSON).content(asJsonString(team1)));
        System.out.println("Post method executed");
        // verify(accountService, times(1)).find(acc.getAccountId());
        // verify(accountService, times(1)).save(acc);
        // verifyNoMoreInteractions(accountService);
    }

    @Test
    public void deleteByID() throws Exception {
        List<Team> alist = new ArrayList<Team>();
        alist.add(team1);
        when(teamService.findByTeamId(team1.getTeamid())).thenReturn(team1);
        mockMvc.perform(delete(DELETE, team1.getTeamid()));
        // verify(eventService, times(1)).find(currentevent.getId());
        // verify(teamService, times(1)).deleteTeamById(team1.getTeamid());
        // verifyNoMoreInteractions(teamService);
        System.out.println("Delete method executed");
    }

    @Test
    public void updateByID() throws Exception {
        List<Team> alist = new ArrayList<Team>();
        alist.add(team1);
        when(teamService.findByTeamId(team1.getTeamid())).thenReturn(team1);
        mockMvc.perform(
                put(PUT, team1.getTeamid()).contentType(MediaType.APPLICATION_JSON).content(asJsonString(team1)));
        System.out.println("Update method executed");
        // verify(eventService, times(1)).find(currentevent.getId());
        // verify(eventService, times(1)).save(currentevent);
        // verifyNoMoreInteractions(eventService);
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}