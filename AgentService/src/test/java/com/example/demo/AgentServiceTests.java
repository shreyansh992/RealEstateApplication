package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Agent;
import com.example.demo.repository.AgentRepository;
import com.example.demo.service.AgentServiceImpl;

@SpringBootTest
class AgentServiceTests {

    @Mock
    private AgentRepository agentRepository;

    @InjectMocks
    private AgentServiceImpl service;

    @Test
    public void testCreateUser() {
        Agent agent = new Agent();        
        agent.setId(1L);
        agent.setFirstName("john");
        agent.setLastName("doe");
        agent.setEmail("john.doe@example.com");
        agent.setPhone("9876543210");
        agent.setLicenseNumber("SH1234");
        agent.setCreatedAt(LocalDate.now());
        
        when(agentRepository.save(agent)).thenReturn(agent);

        assertEquals("Agent Created Successfully!", service.createAgent(agent));
        verify(agentRepository, times(1)).save(agent);
    }

}

