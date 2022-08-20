package com.festa.hack.kurly.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Tag extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @Setter
    private String name;

    @Setter
    private LocalDate startDate;

    @Setter
    private LocalDate endDate;

    @Builder
    public Tag(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
