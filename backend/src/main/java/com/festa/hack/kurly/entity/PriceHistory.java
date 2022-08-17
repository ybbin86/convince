package com.festa.hack.kurly.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class PriceHistory extends CreatedTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int price;

    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder
    public PriceHistory(int price, Goods goods) {
        this.price = price;
        this.goods = goods;
    }
}
