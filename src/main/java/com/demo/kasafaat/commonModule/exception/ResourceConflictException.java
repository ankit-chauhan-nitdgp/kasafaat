package com.demo.kasafaat.commonModule.exception;

public class ResourceConflictException extends BaseAppException {
    public ResourceConflictException(String message) {
        super(message, "RESOURCE_CONFLICT");
    }
}
