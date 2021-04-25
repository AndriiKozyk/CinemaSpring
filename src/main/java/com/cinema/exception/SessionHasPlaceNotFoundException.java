package com.cinema.exception;

import com.cinema.model.enums.ErrorType;

public class SessionHasPlaceNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "Sessions place does not found";

    public SessionHasPlaceNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public SessionHasPlaceNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
