package com.demo.kasafaat.dao;

import com.demo.kasafaat.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, Integer> {

    // Find User by phone number
    UserModel findByPhoneNumber(String phoneNumber);

}
