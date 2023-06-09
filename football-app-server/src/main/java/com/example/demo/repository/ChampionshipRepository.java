package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Championship;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship,Long>{

}
