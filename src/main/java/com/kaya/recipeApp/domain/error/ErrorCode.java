package com.kaya.recipeApp.domain.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    RECIPE_NOT_FOUND(HttpStatus.BAD_REQUEST),
    NO_ERRORCODE_FOUND(HttpStatus.INTERNAL_SERVER_ERROR),
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_REQUEST_BODY(HttpStatus.BAD_REQUEST);

    private final HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public static ErrorCode toEnum(String value) {
        try {
            return ErrorCode.valueOf(value);
        } catch (Exception e) {
            return ErrorCode.NO_ERRORCODE_FOUND;
        }
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
