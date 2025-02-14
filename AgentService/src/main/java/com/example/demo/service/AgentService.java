package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Agent;

public interface AgentService {

    Agent createAgent(Agent agent);
    Agent updateAgent(Long agentId, Agent agent);
    void deleteAgent(Long agentId);
    Optional<Agent> findAgentById(Long agentId);
    List<Agent> findAllAgents();
    Optional<Agent> findAgentByEmail(String email);
    List<Agent> findAgentsByLicenseNumber(String licenseNumber);
    
}
