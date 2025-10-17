package com.demo.kasafaat.addressModule.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;             // FK → users table
    private String label;            // Home, Office, etc.
    private String addressLine;
    private String nearbyLandmark;
    private Double latitude;
    private Double longitude;
    private Boolean isDefault = false;
}
