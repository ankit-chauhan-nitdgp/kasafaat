package com.demo.kasafaat.orderModule.dao;

import com.demo.kasafaat.orderModule.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}
