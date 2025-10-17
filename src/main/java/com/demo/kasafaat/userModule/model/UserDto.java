package com.demo.kasafaat.userModule.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String phone;
    private String email;

    public UserDto(Long id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
