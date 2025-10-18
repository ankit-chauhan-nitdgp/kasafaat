package com.demo.kasafaat.orderModule.service;

import com.demo.kasafaat.darkstoreModule.model.DarkStoreModel;
import com.demo.kasafaat.logisticModule.model.RiderModel;
import com.demo.kasafaat.orderModule.dao.OrderRepository;
import com.demo.kasafaat.orderModule.model.Order;
import com.demo.kasafaat.orderModule.model.OrderItem;
import com.demo.kasafaat.orderModule.model.OrderStatus;
import com.demo.kasafaat.userModule.model.UserModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLifecycleService {

    @Autowired
    OrderRepository repo;

    public Order createNewOrder(UserModel user, DarkStoreModel ds, RiderModel rider, List<OrderItem> items) {
        Order o = new Order();
        o.setUser(user);
        o.setDarkStore(ds);
        o.setRider(rider);
        o.setItems(items);
        o.setStatus(OrderStatus.CREATED);
        o.setCreatedAt(LocalDateTime.now());
        return repo.save(o);
    }

    @Transactional
    public Order updateStatus(Long orderId, OrderStatus newStatus) {
        Order order = repo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        OrderStatus current = order.getStatus();

        if (!isValidTransition(current, newStatus)) {
            throw new IllegalStateException("Invalid status transition: " + current + " → " + newStatus);
        }

        order.setStatus(newStatus);
        order.setUpdatedAt(LocalDateTime.now());

        switch (newStatus) {
            case ACCEPTED -> order.setAcceptedAt(LocalDateTime.now());
            case PACKED -> order.setPackedAt(LocalDateTime.now());
            case OUT_FOR_DELIVERY -> order.setOutForDeliveryAt(LocalDateTime.now());
            case DELIVERED -> order.setDeliveredAt(LocalDateTime.now());
            case CANCELLED -> order.setCancelledAt(LocalDateTime.now());
        }

        return repo.save(order);
    }

    private boolean isValidTransition(OrderStatus from, OrderStatus to) {
        return switch (from) {
            case CREATED -> to == OrderStatus.ACCEPTED || to == OrderStatus.CANCELLED;
            case ACCEPTED -> to == OrderStatus.PACKED || to == OrderStatus.CANCELLED;
            case PACKED -> to == OrderStatus.OUT_FOR_DELIVERY || to == OrderStatus.CANCELLED;
            case OUT_FOR_DELIVERY -> to == OrderStatus.DELIVERED || to == OrderStatus.CANCELLED;
            default -> false;
        };
    }
}
