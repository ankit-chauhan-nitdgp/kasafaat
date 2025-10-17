package com.demo.kasafaat.addressModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class AddressNotFoundException extends BaseAppException {
    public AddressNotFoundException(Long id) {
        super("Address not found with id " + id, "ADDRESS_NOT_FOUND");
    }
}
