package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class NotFoundException  extends RuntimeException  {

    public NotFoundException(String exception) {
        super(exception);
    }

}
