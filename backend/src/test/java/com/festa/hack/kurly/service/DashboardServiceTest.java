package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.Goods;
import com.festa.hack.kurly.entity.PriceHistory;
import com.festa.hack.kurly.repository.GoodsRepository;
import com.festa.hack.kurly.repository.PriceHistoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootTest
@ActiveProfiles("local")
class DashboardServiceTest {

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    @Rollback(value = false)
    void insertTest() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before7 = now.minusDays(7);

        List<String> times = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();

        long id = 1;
        Goods goods = goodsRepository.findById(2L)
                .orElseThrow(EntityNotFoundException::new);

        for (int i = 0; i < 168; i++) {
            LocalDateTime ldt = before7.plusHours(i);
            String label = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt);
            times.add(label);
            prices.add(getRandomPrice());

            LocalDateTime formatLocalDateTimeNow =
                    LocalDateTime.parse(label, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            PriceHistory priceHistory = PriceHistory.builder()
                    .goods(goods)
                    .price(getRandomPrice())
                    //.createdTime(formatLocalDateTimeNow)
                    .build();

            priceHistoryRepository.save(priceHistory);

        }
    }

    private int getRandomPrice() {
        Random random = new Random();
        int createNum = 0;
        String ranNum = "";
        int letter = 5;
        String resultNum = "";

        for (int i = 0; i < letter; i++) {

            createNum = random.nextInt(9);
            ranNum = Integer.toString(createNum);
            resultNum += ranNum;
        }

        return Integer.parseInt(resultNum);

    }

    @Test
    void dashBoardTest() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before7 = now.minusDays(7);

        List<PriceHistory> priceHistoryList = priceHistoryRepository.findAllByGoodsIdAndCreatedTimeAfter(2L, before7);
        //List<LocalDateTime> labels = priceHistoryList.stream().map(PriceHistory::getCreatedTime).collect(Collectors.toList());
        List<Integer> prices = priceHistoryList.stream().map(PriceHistory::getPrice).collect(Collectors.toList());
        //System.out.println(labels);
        System.out.println(prices);
    }
}