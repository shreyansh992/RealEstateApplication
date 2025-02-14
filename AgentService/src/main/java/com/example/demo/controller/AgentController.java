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

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentService agentService;
    
    @Autowired
    PropertyClient client;

    @PostMapping("/create")
    public Agent createAgent(@RequestBody Agent agent) {
        Agent createdAgent = agentService.createAgent(agent);
        return createdAgent;
    }

    @PutMapping("/update/{id}")
    public Agent updateAgent(@PathVariable Long id, @Valid @RequestBody Agent agent) {
        Agent updatedAgent = agentService.updateAgent(id, agent);
        return updatedAgent;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAgent(@PathVariable Long id) {
        agentService.deleteAgent(id);
        return "Agent Deleted successfully!";
    }

    @GetMapping("/get/{id}")
    public Optional<Agent> getAgentById(@PathVariable Long id) {
        Optional<Agent> agent = agentService.findAgentById(id);
        return agent;
    }

    @GetMapping("/getAll")
    public List<Agent> getAllAgents() {
        List<Agent> agents = agentService.findAllAgents();
        return agents;
    }

    @GetMapping("/byEmail/{email}")
    public Optional<Agent> getAgentByEmail(@PathVariable String email) {
        Optional<Agent> agent = agentService.findAgentByEmail(email);
        return agent;
    }

    @GetMapping("/byLicense/{licenseNumber}")
    public List<Agent> getAgentsByLicenseNumber(@PathVariable String licenseNumber) {
        List<Agent> agents = agentService.findAgentsByLicenseNumber(licenseNumber);
        return agents;
    }
    
    @PostMapping("/createProperty")
    public String createProperty(@RequestBody PropertyDTO propertyDTO) {
    	client.createProperty(propertyDTO);
    	return "Property Created Successfully!";
    }
}
