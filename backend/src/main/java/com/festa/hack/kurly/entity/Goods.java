package com.festa.hack.kurly.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.festa.hack.kurly.converter.StringListConverter;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Goods extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String hashValue;

    @Column(nullable = false)
    private String name;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Convert(converter = StringListConverter.class)
    @Column(columnDefinition = "json")
    @Getter
    private List<String> sellGoodsList;

    @Column(nullable = false)
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

    @Builder
    public Goods(String hashValue, String name, Category category, List<String> sellGoodsList, String image, String detailImage, int price, int cost, float marginMax, float marginMin) {
        this.hashValue = hashValue;
        this.name = name;
        this.category = category;
        this.sellGoodsList = sellGoodsList;
        this.image = image;
        this.detailImage = detailImage;
        this.price = price;
        this.cost = cost;
        this.marginMax = marginMax;
        this.marginMin = marginMin;
    }
}
