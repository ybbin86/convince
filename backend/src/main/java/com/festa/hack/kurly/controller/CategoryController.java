package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/category" )
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger( CategoryController.class );

    @Autowired
    private CategoryService categoryService;

    @RequestMapping( method = RequestMethod.GET, value = "/{depth}" )
    public ResponseEntity get(@PathVariable( "depth" ) int depth ) {

        logger.info( "method: GET, api: /category/{depth} - depth: {}", depth );

        return categoryService.findAll(depth);
    }
}