package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class ConstraintViolationException extends RuntimeException {

    public ConstraintViolationException(String exception) {
        super(exception);
    }

}
