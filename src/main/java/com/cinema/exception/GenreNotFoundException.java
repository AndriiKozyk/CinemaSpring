package com.cinema.exception;

import com.cinema.model.enums.ErrorType;

public class GenreNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Genre does not found";

    public GenreNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public GenreNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
