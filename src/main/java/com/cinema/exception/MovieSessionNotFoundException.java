package com.cinema.exception;

import com.cinema.model.enums.ErrorType;

public class MovieSessionNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Movie session does not found";

    public MovieSessionNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public MovieSessionNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
