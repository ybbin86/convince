package com.festa.hack.kurly.service;

import com.festa.hack.kurly.dto.GoodsDto;
import com.festa.hack.kurly.entity.Category;
import com.festa.hack.kurly.entity.Goods;
import com.festa.hack.kurly.entity.PriceHistory;
import com.festa.hack.kurly.entity.User;
import com.festa.hack.kurly.exception.CustomException;
import com.festa.hack.kurly.repository.CategoryRepository;
import com.festa.hack.kurly.repository.GoodsRepository;
import com.festa.hack.kurly.repository.PriceHistoryRepository;
import com.festa.hack.kurly.repository.UserRepository;
import com.festa.hack.kurly.type.ErrorCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class GoodsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ResponseEntity create(GoodsDto goodsDto) {

        Category category = categoryRepository.findById(goodsDto.getCategoryId())
                .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));

        User user = userRepository.findUserByEmail(goodsDto.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));

        String uuid = UUID.randomUUID().toString();

        Goods entity = modelMapper.map(goodsDto, Goods.class);
        entity.setUser(user);
        entity.setCategory(category);
        entity.setHashValue(uuid);

        Goods goods = goodsRepository.save(entity);

        PriceHistory priceHistory = PriceHistory.builder()
                .price(goods.getPrice())
                .goods(goods)
                .build();

        priceHistoryRepository.save(priceHistory);

        return ResponseEntity.ok().build();
    }
}
