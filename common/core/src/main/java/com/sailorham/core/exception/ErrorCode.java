package com.sailorham.core.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getStatus();

    String getMessageKey();

    /**
     * 고유 비즈니스 에러 코드를 반환합니다.
     * Enum 기반 구현체는 {@code name()}을, 그 외 구현체는 자유롭게 정의할 수 있습니다.
     */
    String getCode();
}
