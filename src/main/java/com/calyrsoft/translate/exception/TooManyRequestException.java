package com.calyrsoft.translate.exception;

import org.springframework.http.HttpStatus;

import java.util.List;

public class TooManyRequestException extends ErrorResponse{
    public TooManyRequestException(
            String message,
            String detail,
            List<String> errors
    ) {
        ErrorBody errorBody = new ErrorBody(
            message,
                detail,
                errors,
                HttpStatus.TOO_MANY_REQUESTS,
                HttpStatus.TOO_MANY_REQUESTS.value()
        );
        this.body = errorBody;
    }
}

