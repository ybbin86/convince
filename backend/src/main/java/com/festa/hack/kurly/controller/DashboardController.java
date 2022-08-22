package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.service.DashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/dashboard" )
@Slf4j
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity detail(@PathVariable long id) {

        log.info( "method: GET, api: /dashboard/{id} - id: {}", id);

        return dashboardService.get(id);
    }
}
