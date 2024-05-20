package com.calyrsoft.translate.exception;

import org.springframework.http.HttpStatus;
import java.util.List;


public class ErrorBody {
    private String message;
    private String detail;
    private List<String> errors;
    private HttpStatus status;
    private int statusCode;

    public ErrorBody(String message, String detail, List<String> errors, HttpStatus status, int statusCode) {
        this.message = message;
        this.detail = detail;
        this.errors = errors;
        this.status = status;
        this.statusCode = statusCode;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
