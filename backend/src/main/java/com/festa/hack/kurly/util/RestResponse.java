package com.festa.hack.kurly.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class RestResponse {
    public static ResponseEntity<Map<String, Object>> fail(final HttpStatus status, final String errorMessage) {
        Map<String, Object> result = new HashMap<>();
        result.put("error_message", errorMessage);
        return ResponseEntity.status(status)
                .body(result);

    }
}
