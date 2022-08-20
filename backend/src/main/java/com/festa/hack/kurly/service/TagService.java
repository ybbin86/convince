package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.Tag;
import com.festa.hack.kurly.repository.TagRepository;
import com.festa.hack.kurly.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public ResponseEntity<List<Tag>> findAll(String name) {

        List<Tag> tagList;
        if (ObjectUtils.isEmpty(name)) {
            tagList = tagRepository.findAll();
        } else {
            tagList = tagRepository.findAllByName(name);
        }

        return ResponseEntity.ok(tagList);
    }

    public ResponseEntity create(Tag req) {

        try {
            tagRepository.save(req);
        } catch (DataAccessException e) {
            return RestResponse.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
