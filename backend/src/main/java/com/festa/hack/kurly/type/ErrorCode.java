package com.festa.hack.kurly.type;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "필수값을 입력해주세요."),
    SIGNUP_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "회원가입이 실패하였습니다."),
    TOKEN_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "토큰 생성이 실패하였습니다."),
    TAG_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "태그 생성이 실패하였습니다."),
    PRICE_HISTORY_NOT_FOUND(HttpStatus.NOT_FOUND, "상품의 가격 히스토리를 찾을 수 없습니다."),
    GOODS_NOT_FOUND(HttpStatus.NOT_FOUND, "상품을 찾을 수 없습니다."),
    TAG_NOT_FOUND(HttpStatus.NOT_FOUND, "태그를 찾을 수 없습니다."),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "카테고리를 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.");

    @Getter
    private final HttpStatus status;

    @Getter
    private final String message;



    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
