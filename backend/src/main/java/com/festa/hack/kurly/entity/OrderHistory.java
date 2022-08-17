package com.festa.hack.kurly.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class OrderHistory extends CreatedTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Setter
    private User user;

    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    @Setter
    private Goods goods;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private float margin;

    @Builder
    public OrderHistory(User user, Goods goods, int price, float margin) {
        this.user = user;
        this.goods = goods;
        this.price = price;
        this.margin = margin;
    }
}
