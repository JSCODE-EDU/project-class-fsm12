package com.jscode.spring.exception.exception;

import com.jscode.spring.exception.ErrorCode;

public class PostNotFoundException extends RuntimeException{
    private ErrorCode errorCode;

    public PostNotFoundException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
