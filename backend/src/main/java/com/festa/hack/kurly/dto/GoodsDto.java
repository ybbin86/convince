package com.festa.hack.kurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class GoodsDto {

    private String email;

    @JsonProperty("category_id")
    private long categoryId;

    private String name;

    private String image;

    @JsonProperty("detail_image")
    private String detailImage;

    private int price; // 상품 가격

    private int cost; // 원가

    @JsonProperty("margin_max")
    private float marginMax;

    @JsonProperty("margin_min")
    private float marginMin;

}
