package com.demo.kasafaat.logisticModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class LogisticsTrackingException extends BaseAppException {
    public LogisticsTrackingException(String trackingId) {
        super("Failed to track logistics with ID: " + trackingId, "LOGISTICS_TRACKING_FAILED");
    }
}
