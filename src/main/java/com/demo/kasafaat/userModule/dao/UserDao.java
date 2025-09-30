package com.demo.kasafaat.userModule.dao;

import com.demo.kasafaat.userModule.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserModel, Integer> {

    // Find User by phone number
    UserModel findByPhoneNumber(String phoneNumber);

}
