package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class SqlException extends RuntimeException  {

    public SqlException(String exception) {
        super(exception);
    }

}
