package com.demo.kasafaat.darkstoreModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class DarkstoreNotFoundException extends BaseAppException {
    public DarkstoreNotFoundException(Long id) {
        super("Darkstore not found with id " + id, "DARKSTORE_NOT_FOUND");
    }
}
