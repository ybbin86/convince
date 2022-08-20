package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.User;
import com.festa.hack.kurly.repository.UserRepository;
import com.festa.hack.kurly.type.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityExistsException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("local")
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void login() {

        User user = userRepository.findUserByEmail("test@kurly.com").orElseThrow(EntityExistsException::new);
        Assertions.assertEquals("관리자", user.getName());
    }

    @Test
    void signUp() {

        User user = User.builder()
                .name("관리자")
                .email("test@kurly.com")
                .password("1234")
                .role(Role.ADMIN.getRole())
                .build();

        try{
            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}