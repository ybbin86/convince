package com.festa.hack.kurly.repository;

import com.festa.hack.kurly.entity.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    @Query(  value = "SELECT * FROM price_history WHERE goods_id = ?1 ORDER BY created_time desc LIMIT 1,1",   nativeQuery = true)
    Optional<PriceHistory> findPriceHistoryByGoodsIdBeforePrice(long goodsId);
}
