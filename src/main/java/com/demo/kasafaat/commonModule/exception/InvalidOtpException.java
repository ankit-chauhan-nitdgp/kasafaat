package com.demo.kasafaat.commonModule.exception;

public class InvalidOtpException extends BaseAppException {
        public InvalidOtpException() {
        super("Invalid OTP provided", "INVALID_OTP");
    }
}
