package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.Category;
import com.festa.hack.kurly.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;


@SpringBootTest
@ActiveProfiles({"local"})
class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void save() {
        Category category = Category.builder()
                .name("사과")
                .depth(2)
                .parentId(1)
                .build();
        categoryRepository.save(category);
    }

    @Test
    void findAll() {

        int depth = 0;
        List<Category> categoryList;

        if (depth > 0) {
            categoryList = categoryRepository.findAllByDepth(depth);
        } else {
            categoryList = categoryRepository.findAll();
        }

        Assertions.assertEquals(categoryList.size(), 1);

    }
}