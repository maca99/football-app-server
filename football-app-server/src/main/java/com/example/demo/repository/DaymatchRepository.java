package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Daymatch;

@Repository
public interface DaymatchRepository extends JpaRepository<Daymatch,Long>{

}
