package com.kg.sonardemo.service;

import java.util.List;

import com.kg.sonardemo.entity.Team;



public interface TeamService {

    public Team createTeam(Team team);
    public List<Team> getTeams();
    public Team findByTeamId(Long id);
    public Team updateTeam(Long id,Team team);
    public void deleteTeamById(Long id); 

}
