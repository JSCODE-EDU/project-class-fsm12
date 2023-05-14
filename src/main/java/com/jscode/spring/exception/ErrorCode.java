package com.jscode.spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    POST_NOT_FOUND_ERROR(400, "POST-NOT-FOUND", "POST NOT FOUND ERROR");

    private int status;
    private String errorCode;
    private String message;
}
