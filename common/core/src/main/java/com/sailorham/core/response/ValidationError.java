package com.sailorham.core.response;

public record ValidationError(
    String field,
    String message,
    Object rejectedValue
) {

}
