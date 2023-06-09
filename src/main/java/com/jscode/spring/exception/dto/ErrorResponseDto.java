package com.jscode.spring.exception.dto;

import com.jscode.spring.exception.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    private int status;
    private String code;
    private String message;

    public ErrorResponseDto(ErrorCode errorCode) {
        this.status = errorCode.getStatus();
        this.code = errorCode.getErrorCode();
        this.message = errorCode.getMessage();
    }
    public ErrorResponseDto(ErrorCode errorCode, String message) {
        this.status = errorCode.getStatus();
        this.code = errorCode.getErrorCode();
        this.message = message;
    }
}
