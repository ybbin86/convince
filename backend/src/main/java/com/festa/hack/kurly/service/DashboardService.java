package com.festa.hack.kurly.service;

import com.festa.hack.kurly.custom.CustomException;
import com.festa.hack.kurly.entity.PriceHistory;
import com.festa.hack.kurly.repository.PriceHistoryRepository;
import com.festa.hack.kurly.type.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DashboardService {

    private final int refDay = 7;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    public ResponseEntity get(long id) {

        if (id < 1) {
            log.error("상품 아이디는 필수값입니다.");
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime before7 = ldt.minusDays(refDay);
        String strBefore7 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(before7);

        List<PriceHistory> priceHistoryList = priceHistoryRepository.findAllByGoodsIdAndCreatedTimeAfter(id, strBefore7);

        List<String> labels = priceHistoryList.stream().map(PriceHistory::getCreatedTime).collect(Collectors.toList());
        List<Integer> prices = priceHistoryList.stream().map(PriceHistory::getPrice).collect(Collectors.toList());

        Map<String, Object> result = new HashMap<>();
        result.put("label", labels);
        result.put("data", prices);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }
}
