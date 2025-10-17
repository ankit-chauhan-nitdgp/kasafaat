package com.demo.kasafaat.darkstoreModule.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "darkstores")
public class DarkStoreModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double lat;
    private double lon;
    private double serviceRadiusKm;
    private boolean active;
}
