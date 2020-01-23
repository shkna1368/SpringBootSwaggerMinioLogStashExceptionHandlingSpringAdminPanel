package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class ServiceException extends RuntimeException {

    public ServiceException(String exception) {
        super(exception);
    }

}