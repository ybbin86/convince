package com.festa.hack.kurly.repository;

import com.festa.hack.kurly.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAll();
    List<Tag> findAllByNameContains(String name);
}
