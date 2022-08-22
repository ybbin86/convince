package com.festa.hack.kurly.service;

import com.festa.hack.kurly.dto.GoodsDto;
import com.festa.hack.kurly.entity.PriceHistory;
import com.festa.hack.kurly.repository.PriceHistoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityExistsException;

@SpringBootTest
@ActiveProfiles("local")
class GoodsServiceTest {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Test
    void findPriceHistory() {

        PriceHistory priceHistory =  priceHistoryRepository.findPriceHistoryByGoodsIdBeforePrice(1L)
                .orElseThrow(EntityExistsException::new);

        int beforePrice = priceHistory.getPrice();
        Assertions.assertEquals(8000, beforePrice);

    }

    @Test
    @Rollback(value = false)
    void create() {
        GoodsDto.Create dto = new GoodsDto.Create();
        dto.setCategoryId(2);
        dto.setEmail("test@kurly.com");
        dto.setImage("/test.png");
        dto.setName("melon");
        dto.setPrice(3000);
        dto.setCost(3000);
        dto.setMarginMax(30);
        dto.setMarginMin(30);

        goodsService.create(dto);

    }


}