package com.festa.hack.kurly.service;

import com.festa.hack.kurly.custom.CustomException;
import com.festa.hack.kurly.entity.Category;
import com.festa.hack.kurly.repository.CategoryRepository;
import com.festa.hack.kurly.type.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity findAll(int depth, int parentId) {

        List<Category> categories;

        // 상위 카테고리
        if (depth == 1){
            categories = categoryRepository.findAllByDepth(depth);
        // 하위 카테고리
        } else {
            if (parentId < 1) {
                throw new CustomException(ErrorCode.BAD_REQUEST);
            }
            categories = categoryRepository.findAllByParentIdAndDepth(parentId, depth);
        }

        return ResponseEntity.ok(categories);
    }
}
