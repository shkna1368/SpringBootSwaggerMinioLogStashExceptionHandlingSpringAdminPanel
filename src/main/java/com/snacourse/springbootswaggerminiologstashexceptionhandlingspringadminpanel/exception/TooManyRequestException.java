package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class TooManyRequestException extends RuntimeException  {

    public TooManyRequestException(String exception) {
        super(exception);
    }

}
