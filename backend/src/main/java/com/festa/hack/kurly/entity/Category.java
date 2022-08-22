package com.festa.hack.kurly.entity;

import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int depth;

    @Column(nullable = false)
    @Getter
    @Setter
    private int parentId;

    @Setter
    @Column(nullable = false)
    private float seasonPoint;

    @Builder
    public Category(String name, int depth, int parentId, float seasonPoint) {
        this.name = name;
        this.depth = depth;
        this.parentId = parentId;
        this.seasonPoint = seasonPoint;
    }
}
