package com.demo.kasafaat.addressModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class InvalidAddressException extends BaseAppException {
    public InvalidAddressException(String reason) {
        super("Invalid address: " + reason, "INVALID_ADDRESS");
    }
}
