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

        // 정렬을 위한 필수값 체크
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

        // 페이징 처리를 위한 값
        Pageable pageable = PageRequest.of( goodsDto.getPage(), goodsDto.getSize(), direction, sort[0]);

        long categoryId = goodsDto.getCategoryId();
        String name = goodsDto.getName();

        Specification<Goods> spec = (root, query, criteriaBuilder) -> null;

        // 검색값에 따른 조건 추가
        if (categoryId > 0) {
            spec = Specification.where(GoodsSpecific.equalCategoryId(categoryId));
        }
        if(!ObjectUtils.isEmpty(name)) {
            spec = spec.and(GoodsSpecific.likeName(name));
        }

        Page<Goods> goods = null;
        try {
            goods = goodsRepository.findAll(spec, pageable);
        } catch (Exception e) {

            System.out.printf(e.getStackTrace().toString());
        }


        List<GoodsDto.GetRes> res = new ArrayList<>();
        for (Goods content : goods.getContent()) {
            // 상품에 등록된 태그 목록 조회
            List<GoodsTagMap> goodsTagMaps = goodsTagMapRepository.findAllByGoodsId(content.getId());

            List<String> tags = new ArrayList<>();
            for (GoodsTagMap goodsTagMap : goodsTagMaps) {
                tags.add(goodsTagMap.getTag().getName());
            }

            // 상품의 1시간 전 가격 조회
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

        // 카테고리 아이디 필수값 체크
        Category category = categoryRepository.findById(goodsDto.getCategoryId())
                .orElseThrow(() -> new CustomException(ErrorCode.CATEGORY_NOT_FOUND));

        // 유저 이메일 필수값 체크
        User user = userRepository.findUserByEmail(goodsDto.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));


        Goods entity = modelMapper.map(goodsDto, Goods.class);
        entity.setUser(user);
        entity.setCategory(category);

        Goods goods = goodsRepository.save(entity);

        for (long tagId : goodsDto.getTags()) {
            // 존재하는 태그인지 체크
            Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new CustomException(ErrorCode.TAG_NOT_FOUND));
            GoodsTagMap goodsTagMap = GoodsTagMap.builder()
                    .goods(goods)
                    .tag(tag)
                    .build();

            // 상품에 태그 등록
            goodsTagMapRepository.save(goodsTagMap);
        }

        // 상품의 가격 정보 등록
        PriceHistory priceHistory = PriceHistory.builder()
                .price(goods.getPrice())
                .goods(goods)
                .build();

        priceHistoryRepository.save(priceHistory);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity update(long id, int dynamicPricing) {

        // 상품 존재 여부 체크
        Goods goods = goodsRepository.findById(id)
                .orElseThrow(()-> new CustomException(ErrorCode.GOODS_NOT_FOUND));

        // 다이나믹 프라이싱 적용 여부 변경
        goods.setDynamicPricing(dynamicPricing);

        goodsRepository.save(goods);

        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
