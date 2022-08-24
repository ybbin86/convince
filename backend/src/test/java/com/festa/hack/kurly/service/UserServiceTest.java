package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.User;
import com.festa.hack.kurly.repository.UserRepository;
import com.festa.hack.kurly.type.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityExistsException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void login() {


        User user = userRepository.findUserByEmail("test@kurly.com").orElseThrow(EntityExistsException::new);
        boolean result = passwordEncoder.matches("1111", user.getPassword());
        assertTrue(result);
    }

    @Test
    void signUp() {

        User user = User.builder()
                .name("관리자")
                .email("test@kurly.com")
                .password(passwordEncoder.encode("1111"))
                .role(Role.ADMIN.getRole())
                .build();

        try{
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}