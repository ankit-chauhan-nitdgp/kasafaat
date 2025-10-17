package com.demo.kasafaat.userModule.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column()
    private Long defaultAddressId;
}