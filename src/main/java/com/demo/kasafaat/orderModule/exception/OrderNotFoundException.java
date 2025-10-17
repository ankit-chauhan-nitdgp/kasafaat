package com.demo.kasafaat.orderModule.exception;

import com.demo.kasafaat.commonModule.exception.BaseAppException;

public class OrderNotFoundException extends BaseAppException {
    public OrderNotFoundException(Long id) {
        super("Order not found with id " + id, "ORDER_NOT_FOUND");
    }
}
