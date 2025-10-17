package com.demo.kasafaat.commonModule.exception;

public class UnauthorizedAccessException extends BaseAppException {
    public UnauthorizedAccessException() {
        super("Unauthorized access", "UNAUTHORIZED");
    }
}
