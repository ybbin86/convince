package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.Tag;
import com.festa.hack.kurly.repository.TagRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;


@SpringBootTest
@ActiveProfiles("local")
class TagServiceTest {

    @Autowired
    private TagRepository tagRepository;

    @Test
    void create() {
        Tag tag = Tag.builder()
                .name("연말")
                .endDate(LocalDate.of(2022, 12, 25))
                .startDate(LocalDate.of(2022,12,31))
                .build();

        tagRepository.save(tag);


    }
}