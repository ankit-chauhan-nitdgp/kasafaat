package com.demo.kasafaat.darkstoreModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class DarkStoreCapacityExceededException extends BaseAppException {
    public DarkStoreCapacityExceededException(String name) {
        super("DarkStore " + name + " capacity exceeded", "DARKSTORE_CAPACITY_EXCEEDED");
    }
}
