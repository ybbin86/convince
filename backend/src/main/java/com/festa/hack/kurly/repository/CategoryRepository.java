package com.festa.hack.kurly.repository;

import com.festa.hack.kurly.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByDepth(int depth);

    List<Category> findAllByParentIdAndDepth(int parentId, int depth);
}
