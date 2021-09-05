package com.kaya.recipeApp.exception;

import com.kaya.recipeApp.domain.error.ErrorCode;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private final ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.name());
        this.errorCode = errorCode;
    }
}
