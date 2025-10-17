package com.demo.kasafaat.orderModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class InvalidOrderStatusException extends BaseAppException {
    public InvalidOrderStatusException(String status) {
        super("Invalid order status: " + status, "INVALID_ORDER_STATUS");
    }
}
