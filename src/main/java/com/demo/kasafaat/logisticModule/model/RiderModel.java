package com.demo.kasafaat.logisticModule.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "riders")
public class RiderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double currentLat;
    private double currentLon;

    @Enumerated(EnumType.STRING)
    private RiderStatus status;

    private Long assignedDarkStoreId; // optional, not FK
}
