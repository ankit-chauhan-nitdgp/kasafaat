package com.demo.kasafaat.addressModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class AddressNotAddedException extends BaseAppException {
    public AddressNotAddedException() {
        super("Address not added ", "ADDRESS_NOT_ADDED");
    }
}