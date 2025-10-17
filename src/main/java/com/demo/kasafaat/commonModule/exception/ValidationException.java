package com.demo.kasafaat.commonModule.exception;

public class ValidationException extends BaseAppException {
    public ValidationException(String message) {
        super(message, "VALIDATION_ERROR");
    }
}
