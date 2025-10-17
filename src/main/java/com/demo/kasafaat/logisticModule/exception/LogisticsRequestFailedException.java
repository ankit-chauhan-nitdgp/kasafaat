package com.demo.kasafaat.logisticModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class LogisticsRequestFailedException extends BaseAppException {
    public LogisticsRequestFailedException(String reason) {
        super("Logistics request failed: " + reason, "LOGISTICS_REQUEST_FAILED");
    }
}
