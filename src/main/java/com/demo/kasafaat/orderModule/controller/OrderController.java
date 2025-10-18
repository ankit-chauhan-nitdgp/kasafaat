package com.demo.kasafaat.orderModule.controller;

import com.demo.kasafaat.addressModule.exception.AddressNotFoundException;
import com.demo.kasafaat.addressModule.model.AddressModel;
import com.demo.kasafaat.addressModule.services.AddressService;
import com.demo.kasafaat.commonModule.api.ApiResponse;
import com.demo.kasafaat.darkstoreModule.services.DarkStoreService;
import com.demo.kasafaat.logisticModule.services.RiderAssignmentService;
import com.demo.kasafaat.orderModule.exception.OrderNotFoundException;
import com.demo.kasafaat.orderModule.model.Order;
import com.demo.kasafaat.orderModule.model.OrderStatus;
import com.demo.kasafaat.orderModule.model.PlaceOrderRequest;
import com.demo.kasafaat.orderModule.service.OrderLifecycleService;
import com.demo.kasafaat.userModule.services.UserService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @Autowired
    DarkStoreService darkstoreService;

    @Autowired
    RiderAssignmentService riderAssignmentService;

    @Autowired
    OrderLifecycleService orderLifecycleService;

    @PostMapping("/place")
    public ApiResponse<Order> placeOrder(@RequestBody PlaceOrderRequest req) {
        var user = userService.findByPhoneNumber(req.getPhoneNumber());

        AddressModel address = addressService.getAddressesById(req.getActiveAddressId())
                .orElseThrow(() -> new AddressNotFoundException(req.getActiveAddressId()));


        //find nearest darkstore
        var darkstore = darkstoreService.findNearest(address.getLatitude(), address.getLongitude());

        // assign rider ()
        var rider = riderAssignmentService.findNearestAvailableRider(darkstore.getLat(), darkstore.getLon());

        //creating new order lifecycle
        var order = orderLifecycleService.createNewOrder(user, darkstore, rider, req.getItems());

        return new ApiResponse<>(true, "Order Successfully placed", order, null);
    }


    @PutMapping("/status")
    public ApiResponse<Order> updateStatus(
            @RequestParam Long orderId,
            @RequestParam OrderStatus newStatus
    ) {

        Order updated = orderLifecycleService.updateStatus(orderId, newStatus);
        if (updated == null){
            throw new OrderNotFoundException(orderId);
        }
        return new ApiResponse<>(true, "Order Status Update", updated, null);
    }
}

