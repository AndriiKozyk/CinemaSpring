package com.cinema.validator;

import com.cinema.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<RepeatPassword, Object> {

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        UserDto userDto = (UserDto) object;
        String password = userDto.getPassword();
        String repeatPassword = userDto.getRepeatPassword();
        if (password == null || repeatPassword == null) {
            return false;
        }
        return password.equals(repeatPassword);
    }

}
