package com.demo.kasafaat.userModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class UserAlreadyExistsException extends BaseAppException {
    public UserAlreadyExistsException(String phone) {
        super("User already exists with phone " + phone, "USER_ALREADY_EXISTS");
    }
}
