package com.sailorham.core.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

    HttpStatus getStatus();

    String getMessageKey();

    String name();

    default String getCode() {
        return this.name();
    }
}
