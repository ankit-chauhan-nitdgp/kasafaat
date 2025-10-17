package com.demo.kasafaat.orderModule.model;

import lombok.Data;

import java.util.List;

@Data
public class PlaceOrderRequest {
    private String phoneNumber;
    private List<OrderItem> items;
}