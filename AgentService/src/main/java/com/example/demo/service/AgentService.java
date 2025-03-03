package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Agent;

/**
 * Service interface for managing agents.
 * 
 * @author Shreyansh Singh
 */
public interface AgentService {

    /**
     * Creates a new agent.
     *
     * @param agent the agent to create
     * @return a message indicating the result of the operation
     */
    String createAgent(Agent agent);

    /**
     * Updates an existing agent.
     *
     * @param agentId the ID of the agent to update
     * @param agent the updated agent information
     * @return the updated agent
     */
    Agent updateAgent(Long agentId, Agent agent);

    /**
     * Deletes an agent by ID.
     *
     * @param agentId the ID of the agent to delete
     */
    void deleteAgent(Long agentId);

    /**
     * Retrieves an agent by ID.
     *
     * @param agentId the ID of the agent to retrieve
     * @return an Optional containing the agent if found, or empty if not found
     */
    Optional<Agent> findAgentById(Long agentId);

    /**
     * Retrieves all agents.
     *
     * @return a list of all agents
     */
    List<Agent> findAllAgents();

    /**
     * Retrieves an agent by email.
     *
     * @param email the email of the agent to retrieve
     * @return an Optional containing the agent if found, or empty if not found
     */
    Optional<Agent> findAgentByEmail(String email);

    /**
     * Retrieves agents by license number.
     *
     * @param licenseNumber the license number of the agents to retrieve
     * @return a list of agents with the specified license number
     */
    List<Agent> findAgentsByLicenseNumber(String licenseNumber);
}