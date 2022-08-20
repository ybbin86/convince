package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.Category;
import com.festa.hack.kurly.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<List<Category>> findAll(int depth) {

        List<Category> categories;
        if (depth > 0) {
            categories = categoryRepository.findAllByDepth(depth);
        } else {
            categories = categoryRepository.findAll();
        }

        return ResponseEntity.ok(categories);
    }
}
