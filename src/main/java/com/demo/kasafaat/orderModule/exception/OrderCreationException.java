package com.demo.kasafaat.orderModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class OrderCreationException extends BaseAppException {
    public OrderCreationException(String reason) {
        super("Order creation failed: " + reason, "ORDER_CREATION_FAILED");
    }
}
