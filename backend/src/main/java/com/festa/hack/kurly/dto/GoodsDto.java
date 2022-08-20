package com.festa.hack.kurly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class GoodsDto {

    @Data
    @Getter
    public static class Create {
        private String email;
        @JsonProperty("category_id")
        private long categoryId;
        private List<Long> tags;
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

    @Getter
    @Data
    public static class GetReq {
        private int size;
        private int page;
        private String sort;
        private String name;
        @JsonProperty("category_id")
        private long categoryId;
        private List<String> tags;
    }

    @Setter
    @Data
    public static class GetRes {
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
        private List<String> tags;
        private String categoryName;
    }


}
