package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class UserFoundException extends RuntimeException {

    public UserFoundException(String message) {
        super(message);
    }
}
