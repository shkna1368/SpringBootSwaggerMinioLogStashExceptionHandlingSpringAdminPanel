package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class RestServiceException extends RuntimeException {

    public RestServiceException(String exception) {
        super(exception);
    }
}
