package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/category" )
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping( method = RequestMethod.GET, value = "/{depth}" )
    public ResponseEntity get(@PathVariable( "depth" ) int depth, int parent_id ) {

        log.info( "method: GET, api: /category/{depth} - depth: {}, parent_id: {}", depth, parent_id );

        return categoryService.findAll(depth, parent_id);
    }
}
