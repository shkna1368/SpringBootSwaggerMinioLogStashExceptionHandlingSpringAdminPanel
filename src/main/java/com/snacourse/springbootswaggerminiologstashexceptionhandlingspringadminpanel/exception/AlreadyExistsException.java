package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String message){
        super(message);
    }
}
