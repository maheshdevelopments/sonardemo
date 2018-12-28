package com.kg.sonardemo.repository;

import com.kg.sonardemo.entity.Team;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TeamRepository
 */
public interface TeamRepository extends JpaRepository<Team,Long>{

    
}