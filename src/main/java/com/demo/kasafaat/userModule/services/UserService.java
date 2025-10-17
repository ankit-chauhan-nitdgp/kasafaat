package com.demo.kasafaat.userModule.services;

import com.demo.kasafaat.addressModule.exception.AddressNotFoundException;
import com.demo.kasafaat.userModule.dao.UserDao;
import com.demo.kasafaat.userModule.exception.UserNotFoundException;
import com.demo.kasafaat.userModule.model.UserModel;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    public UserModel updateDefaultAddress(String phoneNumber, Long defaultAddressId){
        UserModel existingUser = userRepository.findByPhoneNumber(phoneNumber);

        if (existingUser == null ){
            throw new UserNotFoundException(phoneNumber);
        }

        existingUser.setDefaultAddressId(defaultAddressId);
        return userRepository.save(existingUser);
    }

    public UserModel updateActiveAddress(String phoneNumber, Long activeAddressId){
        UserModel existingUser = userRepository.findByPhoneNumber(phoneNumber);

        if (existingUser == null ){
            throw new UserNotFoundException(phoneNumber);
        }

        existingUser.setActiveAddressId(activeAddressId);
        return userRepository.save(existingUser);
    }

}
