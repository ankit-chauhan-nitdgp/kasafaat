package com.demo.kasafaat.userModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class UserNotFoundException extends BaseAppException {
    public UserNotFoundException(String phoneNumber) {
        super("User not found with phoneNumber " + phoneNumber, "USER_NOT_FOUND");
    }
}
