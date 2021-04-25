package com.cinema.exception;

import com.cinema.model.enums.ErrorType;

public class UserDetailsNotFoundException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "User details does not found";

    public UserDetailsNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public UserDetailsNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }

}
