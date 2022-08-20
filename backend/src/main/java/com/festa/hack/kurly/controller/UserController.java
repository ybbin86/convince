package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.entity.User;
import com.festa.hack.kurly.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(HttpServletResponse response, @RequestBody final User user) {

        log.info("method: POST, api: /login, email: {}", user.getEmail());

        return userService.login(user, response);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public ResponseEntity logout() {

        log.info("method: POST, api: /logout");

        return userService.logout();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(@RequestBody final User user) {

        log.info("method: POST, api: /signup");

        return userService.signUp(user);
    }
}
