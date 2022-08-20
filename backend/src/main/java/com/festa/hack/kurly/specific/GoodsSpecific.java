package com.festa.hack.kurly.specific;

import com.festa.hack.kurly.entity.Goods;
import org.springframework.data.jpa.domain.Specification;

public class GoodsSpecific {
    public static Specification<Goods> equalCategoryId(long categoryId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("categoryId"), categoryId);
    }

    public static Specification<Goods> likeName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
