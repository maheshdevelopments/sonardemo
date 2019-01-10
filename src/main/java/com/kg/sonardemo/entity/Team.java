package com.kg.sonardemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Team
 */
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teamid;

    private String teamname;

    /**
     * @return the teamid
     */
    public long getTeamid() {
        return teamid;
    }

    /**
     * @param l the teamid to set
     */
    public void setTeamid(long l) {
        this.teamid = l;
    }

    /**
     * @return the teamname
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * @param teamname the teamname to set
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    @Override
    public String toString() {
        return teamid + teamname;
    }

    public Object willReturn(Team team1) {
        return null;
    }
}