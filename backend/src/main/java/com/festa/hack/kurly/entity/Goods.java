package com.festa.hack.kurly.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Goods extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    private String detailImage;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    private float marginMax;

    @Column(nullable = false)
    private float marginMin;

    @Column(length = 1, nullable = false, columnDefinition = "integer default 1")
    @ColumnDefault("1") // 0:disable, 1:enable
    @Setter
    private int dynamicPricing;

    @Builder
    public Goods(String name, Category category, String image, String detailImage, int price, int cost, float marginMax, float marginMin, int dynamicPricing) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.detailImage = detailImage;
        this.price = price;
        this.cost = cost;
        this.marginMax = marginMax;
        this.marginMin = marginMin;
        this.dynamicPricing = dynamicPricing;
    }
}
