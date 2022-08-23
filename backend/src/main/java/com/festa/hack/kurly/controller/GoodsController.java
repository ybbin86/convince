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

    @RequestMapping( method = RequestMethod.GET )
    public ResponseEntity get(GoodsDto.GetReq goodsDto) {

        log.info( "method: GET, api: /goods - size: {}, page: {}, sort: {}, name: {}, category_id: {}", goodsDto.getSize(), goodsDto.getPage(), goodsDto.getSort(), goodsDto.getName(), goodsDto.getCategoryId());

        return goodsService.get(goodsDto);
    }

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity create(@RequestBody GoodsDto.Create goodsDto) {

        log.info( "method: POST, api: /goods - name: {}, email: {}, category_id: {}, image: {}, detail_image: {}, price: {}, cost: {}, margin_max: {}, margin_min: {}, dynamic_pricing: {}",
                goodsDto.getName(), goodsDto.getEmail(), goodsDto.getCategoryId(), goodsDto.getImage(), goodsDto.getDetailImage(), goodsDto.getPrice(), goodsDto.getCost(), goodsDto.getMarginMax(), goodsDto.getMarginMin(), goodsDto.getDynamicPricing() );

        return goodsService.create(goodsDto);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET )
    public ResponseEntity detail(@PathVariable long id) {

        log.info( "method: GET, api: /goods/{id} - id: {}", id);

        return goodsService.detail(id);
    }

}
