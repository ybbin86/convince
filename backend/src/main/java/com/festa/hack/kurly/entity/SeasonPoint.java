package com.festa.hack.kurly.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class SeasonPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    @Setter
    private Goods goods;

    @Column(nullable = false)
    private int month;

    @Column(nullable = false)
    private float seasonPoint;

}
