package com.festa.hack.kurly.service;

import com.festa.hack.kurly.entity.*;
import com.festa.hack.kurly.repository.*;
import com.festa.hack.kurly.specific.GoodsSpecific;
import com.festa.hack.kurly.dto.GoodsDto;
import com.festa.hack.kurly.custom.CustomException;
import com.festa.hack.kurly.type.ErrorCode;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class GoodsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private GoodsTagMapRepository goodsTagMapRepository;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity get(GoodsDto.GetReq goodsDto) {

        if (ObjectUtils.isEmpty(goodsDto.getSort()) || !goodsDto.getSort().contains(":")) {
            throw new CustomException(ErrorCode.BAD_REQUEST);
        }

        String[] sort = goodsDto.getSort().split(":");
        Sort.Direction direction;
        if (sort[1].equals("desc")) {
            direction = Sort.Direction.DESC;
        } else {
            direction = Sort.Direction.ASC;
        }

        Pageable pageable = PageRequest.of( goodsDto.getPage(), goodsDto.getSize(), direction, sort[0]);

        long categoryId = goodsDto.getCategoryId();
        String name = goodsDto.getName();

        Specification<Goods> spec = (root, query, criteriaBuilder) -> null;

        if (categoryId > 0) {
            spec = Specification.where(GoodsSpecific.equalCategoryId(categoryId));
        }
        if(!ObjectUtils.isEmpty(name)) {
            spec = spec.and(GoodsSpecific.likeName(name));
        }

        Page<Goods> goods = goodsRepository.findAll(spec, pageable);

        List<GoodsDto.GetRes> res = new ArrayList<>();
        for (Goods content : goods.getContent()) {
            List<GoodsTagMap> goodsTagMaps = goodsTagMapRepository.findAllByGoodsId(content.getId());

            List<String> tags = new ArrayList<>();
            for (GoodsTagMap goodsTagMap : goodsTagMaps) {
                tags.add(goodsTagMap.getTag().getName());
            }

            int beforePrice = 0;
            Optional<PriceHistory> priceHistory = priceHistoryRepository.findPriceHistoryByGoodsIdBeforePrice(content.getId());
            if (priceHistory.isPresent()) {
                beforePrice = priceHistory.get().getPrice();
            }

            GoodsDto.GetRes dto = modelMapper.map(content, GoodsDto.GetRes.class);
            dto.setTags(tags);
            dto.setBeforePrice(beforePrice);

            res.add(dto);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("total", goods.getTotalElements());
        result.put("size", goods.getSize());
        result.put("data", res);

        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    @Transactional
    public ResponseEntity create(GoodsDto.Create goodsDto) {

        Category category = categoryRepository.findById(goodsDto.getCategoryId())
                .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));

        User user = userRepository.findUserByEmail(goodsDto.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        String uuid = UUID.randomUUID().toString();

        Goods entity = modelMapper.map(goodsDto, Goods.class);
        entity.setUser(user);
        entity.setCategory(category);
        entity.setHashValue(uuid);

        Goods goods = goodsRepository.save(entity);

        for (long tagId : goodsDto.getTags()) {
            Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new CustomException(ErrorCode.TAG_NOT_FOUND));
            GoodsTagMap goodsTagMap = GoodsTagMap.builder()
                    .goods(goods)
                    .tag(tag)
                    .build();

            goodsTagMapRepository.save(goodsTagMap);
        }

        PriceHistory priceHistory = PriceHistory.builder()
                .price(goods.getPrice())
                .goods(goods)
                .build();

        priceHistoryRepository.save(priceHistory);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity detail(long id) {

        Goods goods = goodsRepository.findById(id)
                .orElseThrow(()-> new CustomException(ErrorCode.GOODS_NOT_FOUND));

        GoodsDto.GetRes dto = this.getDtoRes(goods, id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(dto);

    }

    private GoodsDto.GetRes getDtoRes(Goods goods, long goodsId) {
        List<GoodsTagMap> goodsTagMaps = goodsTagMapRepository.findAllByGoodsId(goodsId);

        List<String> tags = new ArrayList<>();
        for (GoodsTagMap goodsTagMap : goodsTagMaps) {
            tags.add(goodsTagMap.getTag().getName());
        }
        GoodsDto.GetRes dto = modelMapper.map(goods, GoodsDto.GetRes.class);
        dto.setTags(tags);

        return dto;
    }
}
