package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PropertyDTO;
import com.example.demo.clients.PropertyClient;
import com.example.demo.entity.Agent;
import com.example.demo.service.AgentService;

import jakarta.validation.Valid;

/**
 * REST controller for managing agents.
 * 
 * @author Shreyansh Singh
 */
@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;
    
    @Autowired
    private PropertyClient client;

    /**
     * Creates a new agent.
     * 
     * @param agent the agent to create
     * @return a message indicating the result of the operation
     */
    @PostMapping("/create")
    public String createAgent(@RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

    /**
     * Updates an existing agent.
     * 
     * @param id the ID of the agent to update
     * @param agent the updated agent information
     * @return the updated agent
     */
    @PutMapping("/update/{id}")
    public Agent updateAgent(@PathVariable Long id, @Valid @RequestBody Agent agent) {
        return agentService.updateAgent(id, agent);
    }

    /**
     * Deletes an agent by ID.
     * 
     * @param id the ID of the agent to delete
     * @return a message indicating the result of the operation
     */
    @DeleteMapping("/delete/{id}")
    public String deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return "Agent Deleted successfully!";
    }

    /**
     * Retrieves an agent by ID.
     * 
     * @param id the ID of the agent to retrieve
     * @return the agent, if found
     */
    @GetMapping("/get/{id}")
    public Optional<Agent> getAgentById(@PathVariable Long id) {
        return agentService.findAgentById(id);
    }

    /**
     * Retrieves all agents.
     * 
     * @return a list of all agents
     */
    @GetMapping("/getAll")
    public List<Agent> getAllAgents() {
        return agentService.findAllAgents();
    }

    /**
     * Retrieves an agent by email.
     * 
     * @param email the email of the agent to retrieve
     * @return the agent, if found
     */
    @GetMapping("/byEmail/{email}")
    public Optional<Agent> getAgentByEmail(@PathVariable String email) {
        return agentService.findAgentByEmail(email);
    }

    /**
     * Retrieves agents by license number.
     * 
     * @param licenseNumber the license number of the agents to retrieve
     * @return a list of agents with the specified license number
     */
    @GetMapping("/byLicense/{licenseNumber}")
    public List<Agent> getAgentsByLicenseNumber(@PathVariable String licenseNumber) {
        return agentService.findAgentsByLicenseNumber(licenseNumber);
    }

    /**
     * Creates a new property through the PropertyClient.
     * 
     * @param propertyDTO the property data transfer object containing property details
     * @return a message indicating the result of the operation
     */
    @PostMapping("/createProperty")
    public String createProperty(@RequestBody PropertyDTO propertyDTO) {
        client.createProperty(propertyDTO);
        return "Property Created Successfully!";
    }
}