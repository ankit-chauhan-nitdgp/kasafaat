package com.demo.kasafaat.addressModule.model;

import lombok.Data;

@Data
public class AddressDTO {

    private String userPhoneNumber;             // FK → users table
    private String label;            // Home, Office, etc.
    private String addressLine;
    private String nearbyLandmark;
    private Double latitude;
    private Double longitude;

}
