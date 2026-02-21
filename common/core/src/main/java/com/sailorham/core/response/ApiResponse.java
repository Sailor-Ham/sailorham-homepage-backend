package com.sailorham.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sailorham.core.exception.ErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(
    boolean success,
    String code,
    String message,
    T data
) {

    private static final String SUCCESS_CODE = "SUCCESS";

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, SUCCESS_CODE, null, data);
    }

    public static ApiResponse<Void> ok() {
        return new ApiResponse<>(true, SUCCESS_CODE, null, null);
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode, String message) {
        return new ApiResponse<>(false, errorCode.getCode(), message, null);
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode) {
        return new ApiResponse<>(false, errorCode.getCode(), null, null);
    }

    public static <T> ApiResponse<T> fail(ErrorCode errorCode, T data) {
        return new ApiResponse<>(false, errorCode.getCode(), null, data);
    }
}
