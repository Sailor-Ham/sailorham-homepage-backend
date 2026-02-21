package com.sailorham.core.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessException extends RuntimeException {

    ErrorCode errorCode;
    Object[] args;

    public BusinessException(ErrorCode errorCode) {

        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = new Object[0];
    }

    public BusinessException(ErrorCode errorCode, Object... args) {

        super(errorCode.getMessageKey());
        this.errorCode = errorCode;
        this.args = args;
    }

    public BusinessException(ErrorCode errorCode, Throwable cause) {

        super(errorCode.getMessageKey(), cause);
        this.errorCode = errorCode;
        this.args = new Object[0];
    }
}
