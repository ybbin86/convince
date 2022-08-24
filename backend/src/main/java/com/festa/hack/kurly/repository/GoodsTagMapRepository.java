package com.festa.hack.kurly.repository;

import com.festa.hack.kurly.entity.GoodsTagMap;
import com.festa.hack.kurly.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTagMapRepository extends JpaRepository<GoodsTagMap, Long> {

    List<GoodsTagMap> findAllByGoodsId(long goodsId);
}
