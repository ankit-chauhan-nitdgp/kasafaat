package com.demo.kasafaat.services;

import com.demo.kasafaat.dao.UserDao;
import com.demo.kasafaat.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userRepository;

    public UserModel findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    public UserModel registerNewUser(UserModel model){
        return userRepository.save(model);
    }

    public List<UserModel> getAllUser(){
        return userRepository.findAll();
    }

}
