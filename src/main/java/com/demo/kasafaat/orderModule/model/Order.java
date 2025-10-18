package com.demo.kasafaat.orderModule.model;

import com.demo.kasafaat.darkstoreModule.model.DarkStoreModel;
import com.demo.kasafaat.logisticModule.model.RiderModel;
import com.demo.kasafaat.userModule.model.UserModel;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne private UserModel user;
    @ManyToOne private DarkStoreModel darkStore;
    @ManyToOne private RiderModel rider;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    private LocalDateTime createdAt;

    //status update
    private LocalDateTime updatedAt;

    private LocalDateTime acceptedAt;
    private LocalDateTime packedAt;
    private LocalDateTime outForDeliveryAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime cancelledAt;
}
