package com.festa.hack.kurly.controller;

import com.festa.hack.kurly.dto.GoodsDto;
import com.festa.hack.kurly.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/goods" )
@Slf4j
public class GoodsController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping( method = RequestMethod.POST )
    public ResponseEntity create(@RequestBody GoodsDto goodsDto) {

        log.info( "method: POST, api: /goods - email: {}, name: {}, category_id: {}, image: {}, detail_image: {}, price: {}, cost: {}, margin_max: {}, margin_min: {}",
                goodsDto.getName(), goodsDto.getEmail(), goodsDto.getCategoryId(), goodsDto.getImage(), goodsDto.getDetailImage(), goodsDto.getPrice(), goodsDto.getCost(), goodsDto.getMarginMax(), goodsDto.getMarginMin() );

        return goodsService.create(goodsDto);
    }
}
