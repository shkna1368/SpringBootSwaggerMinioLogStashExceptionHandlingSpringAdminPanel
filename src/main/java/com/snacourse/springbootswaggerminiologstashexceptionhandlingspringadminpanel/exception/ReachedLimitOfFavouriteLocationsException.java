package com.snacourse.springbootswaggerminiologstashexceptionhandlingspringadminpanel.exception;

public class ReachedLimitOfFavouriteLocationsException extends RuntimeException {
    public ReachedLimitOfFavouriteLocationsException(String exception) {
        super(exception);
    }
}
