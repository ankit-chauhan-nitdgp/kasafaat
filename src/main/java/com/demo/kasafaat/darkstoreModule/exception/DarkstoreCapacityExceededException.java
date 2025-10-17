package com.demo.kasafaat.darkstoreModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class DarkstoreCapacityExceededException extends BaseAppException {
    public DarkstoreCapacityExceededException(String name) {
        super("Darkstore " + name + " capacity exceeded", "DARKSTORE_CAPACITY_EXCEEDED");
    }
}
