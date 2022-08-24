package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.dto.GoodsDto;
import com.festa.hack.kurly.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/goods" )
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /*
    상품 목록 조회
    */
    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity get(GoodsDto.GetReq goodsDto) {

        log.info( "method: GET, api: /goods - size: {}, page: {}, sort: {}, name: {}, category_id: {}", goodsDto.getSize(), goodsDto.getPage(), goodsDto.getSort(), goodsDto.getName(), goodsDto.getCategoryId());

        return goodsService.get(goodsDto);
    }

    /*
    상품 등록
    */
    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity create(@RequestBody GoodsDto.Create goodsDto) {

        log.info( "method: POST, api: /goods - name: {}, email: {}, category_id: {}, image: {}, detail_image: {}, price: {}, cost: {}, margin_max: {}, margin_min: {}, dynamic_pricing: {}",
                goodsDto.getName(), goodsDto.getEmail(), goodsDto.getCategoryId(), goodsDto.getImage(), goodsDto.getDetailImage(), goodsDto.getPrice(), goodsDto.getCost(), goodsDto.getMarginMax(), goodsDto.getMarginMin(), goodsDto.getDynamicPricing() );

        return goodsService.create(goodsDto);
    }
     /*
     상품 다이나믹 프라이싱 적용 여부 변경
     */
    @RequestMapping( value = "/{id}", method = RequestMethod.POST )
    public ResponseEntity update(@PathVariable long id, @RequestBody GoodsDto.Create goodsDto) {

        log.info( "method: PUT, api: /goods/{id} - id: {}, dynamic_pricing: {}", id, goodsDto.getDynamicPricing());

        return goodsService.update(id, goodsDto.getDynamicPricing());
    }

}
