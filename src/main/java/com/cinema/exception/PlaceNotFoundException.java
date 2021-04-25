package com.cinema.exception;

import com.cinema.model.enums.ErrorType;

public class PlaceNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Place does not found";

    public PlaceNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public PlaceNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
