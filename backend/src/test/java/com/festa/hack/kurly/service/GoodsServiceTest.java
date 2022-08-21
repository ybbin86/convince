package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.PriceHistory;
import com.festa.hack.kurly.repository.PriceHistoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityExistsException;

@SpringBootTest
@ActiveProfiles("local")
class GoodsServiceTest {


    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Test
    void findPriceHistory() {

        PriceHistory priceHistory =  priceHistoryRepository.findPriceHistoryByGoodsIdBeforePrice(1L)
                .orElseThrow(EntityExistsException::new);

        int beforePrice = priceHistory.getPrice();
        Assertions.assertEquals(8000, beforePrice);

    }
}