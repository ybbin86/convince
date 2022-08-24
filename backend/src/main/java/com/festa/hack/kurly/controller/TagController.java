package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.dto.TagDto;
import com.festa.hack.kurly.entity.Tag;
import com.festa.hack.kurly.service.TagService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/tag" )
public class TagController {

    private static final Logger logger = LoggerFactory.getLogger( TagController.class );

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TagService tagService;

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity get(String name) {

        logger.info( "method: GET, api: /tag - name: {}", name );

        return tagService.findAll(name);
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity create(@RequestBody TagDto tagDto) {
        Tag req = modelMapper.map(tagDto, Tag.class);

        logger.info( "method: POST, api: /tag - name: {}, start_date: {}, end_date: {}", req.getName(), req.getStartDate(), req.getEndDate() );

        return tagService.create(req);
    }
}
