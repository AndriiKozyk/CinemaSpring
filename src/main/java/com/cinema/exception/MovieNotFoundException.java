package com.cinema.exception;

import com.cinema.model.enums.ErrorType;

public class MovieNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Movie does not found";

    public MovieNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public MovieNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
