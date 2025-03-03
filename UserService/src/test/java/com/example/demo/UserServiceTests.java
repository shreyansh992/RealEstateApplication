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

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceImpl;

@SpringBootTest
class UserServiceTests {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("john_doe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");
        user.setRole("USER");
        user.setStatus("ACTIVE");
        user.setCreatedDate(LocalDate.now());
        user.setLastLoginDate(LocalDate.now());
        
        when(userRepository.save(user)).thenReturn(user);

        assertEquals("User Created Successfully!", userService.createUser(user));
        verify(userRepository, times(1)).save(user);
    }

}
