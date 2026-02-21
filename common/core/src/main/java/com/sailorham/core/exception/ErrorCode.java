package com.sailorham.core.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getStatus();

    String getMessageKey();

    String name();

    /**
     * Enum 상수 이름(name)을 고유 비즈니스 에러 코드로 사용하기 위한 Default 메서드입니다.
     */
    default String getCode() {
        return this.name();
    }
}
