package com.festa.hack.kurly.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@RequiredArgsConstructor
public class GoodsTagMap extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Goods.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    @Setter
    private Goods goods;

    @ManyToOne(targetEntity = Tag.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    @Setter
    private Tag tag;

    @Builder
    public GoodsTagMap(Goods goods, Tag tag) {
        this.goods = goods;
        this.tag = tag;
    }
}
