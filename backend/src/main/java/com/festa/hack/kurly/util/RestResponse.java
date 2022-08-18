package com.festa.hack.kurly.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestResponse {
    public static ResponseEntity fail(final HttpStatus status, final String errorMessage) {
        return toResponseEntity(status, errorMessage);
    }

    public static ResponseEntity success(final Object obj) {
        return toResponseEntity(HttpStatus.OK, obj);
    }

    public static ResponseEntity success(final Object obj, final long lastModified) {
        return toResponseEntity(HttpStatus.OK, obj, lastModified);
    }

    public static ResponseEntity success() {
        return toResponseEntity(HttpStatus.OK, null);
    }

    public static ResponseEntity toResponseEntity(HttpStatus status, Object obj, long lastModified) {
        return ResponseEntity.status(status)
                .lastModified(lastModified)
                .body(obj);
    }

    public static ResponseEntity toResponseEntity(HttpStatus status, Object obj) {
        return ResponseEntity.status(status)
                .body(obj);
    }
}
