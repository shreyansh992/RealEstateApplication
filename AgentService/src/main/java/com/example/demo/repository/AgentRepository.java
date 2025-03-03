package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Agent;

/**
 * Repository interface for managing agents.
 * 
 * @author Shreyansh Singh
 */
@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    /**
     * Finds an agent by email.
     *
     * @param email the email of the agent to find
     * @return an Optional containing the agent if found, or empty if not found
     */
    Optional<Agent> findByEmail(String email);

    /**
     * Finds agents by first name, ignoring case.
     *
     * @param name the first name of the agents to find
     * @return a list of agents with the specified first name, ignoring case
     */
    List<Agent> findByFirstNameIgnoreCase(String name);

    /**
     * Finds an agent by phone number.
     *
     * @param phone the phone number of the agent to find
     * @return an Optional containing the agent if found, or empty if not found
     */
    Optional<Agent> findByPhone(String phone);

    /**
     * Finds agents by license number.
     *
     * @param licenseNumber the license number of the agents to find
     * @return a list of agents with the specified license number
     */
    List<Agent> findByLicenseNumber(String licenseNumber);
}