package com.demo.kasafaat.orderModule.service;

import com.demo.kasafaat.darkstoreModule.model.DarkStoreModel;
import com.demo.kasafaat.logisticModule.model.RiderModel;
import com.demo.kasafaat.orderModule.dao.OrderRepository;
import com.demo.kasafaat.orderModule.model.Order;
import com.demo.kasafaat.orderModule.model.OrderItem;
import com.demo.kasafaat.orderModule.model.OrderStatus;
import com.demo.kasafaat.userModule.model.UserModel;
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

    public Order updateStatus(Long id, OrderStatus newStatus) {
        Order o = repo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        o.setStatus(newStatus);
        return repo.save(o);
    }
}
