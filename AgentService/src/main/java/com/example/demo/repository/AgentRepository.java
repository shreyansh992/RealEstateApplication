package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Optional<Agent> findByEmail(String email);
    List<Agent> findByFirstNameIgnoreCase(String name);
    Optional<Agent> findByPhone(String phone);
    List<Agent> findByLicenseNumber(String licenseNumber);
  
 }