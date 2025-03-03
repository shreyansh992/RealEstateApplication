package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Agent;
import com.example.demo.exceptions.AgentNotFound;
import com.example.demo.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public String createAgent(Agent agent) {
//        agent.setCreatedAt(LocalDate.now());
          agentRepository.save(agent);
          return "Agent Created Successfully!";
    }

    @Override
    public Agent updateAgent(Long agentId, Agent agent) {
        Optional<Agent> existingAgent = agentRepository.findById(agentId);
        if (existingAgent.isPresent()) {
            Agent updatedAgent = existingAgent.get();
            updatedAgent.setFirstName(agent.getFirstName());
            updatedAgent.setLastName(agent.getLastName());
            updatedAgent.setEmail(agent.getEmail());
            updatedAgent.setPhone(agent.getPhone());
            updatedAgent.setLicenseNumber(agent.getLicenseNumber());
            return agentRepository.save(updatedAgent);
        } else {
            throw new AgentNotFound("Agent not found with id " + agentId);
        }
    }

    @Override
    public void deleteAgent(Long agentId) {
        agentRepository.deleteById(agentId);
    }

    @Override
    public Optional<Agent> findAgentById(Long agentId) {
    	Optional<Agent> existingAgent = agentRepository.findById(agentId);
        if (existingAgent.isPresent()) {
            return agentRepository.findById(agentId);
        } else {
            throw new AgentNotFound("Agent not found with id " + agentId);
        }
    	
    }

    @Override
    public List<Agent> findAllAgents() {
        return agentRepository.findAll();
    }

    @Override
    public Optional<Agent> findAgentByEmail(String email) {
        return agentRepository.findByEmail(email);
    }

    @Override
    public List<Agent> findAgentsByLicenseNumber(String licenseNumber) {
        return agentRepository.findByLicenseNumber(licenseNumber);
    }
}
