package com.demo.kasafaat.userModule.dao;

import com.demo.kasafaat.userModule.model.OTPModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OTPDao  extends JpaRepository<OTPModel, Integer> {

    // Find OTP by phone number
    OTPModel findByPhoneNumber(String phoneNumber);

    // Optional: Find OTP by phone number and OTP value
    OTPModel findByPhoneNumberAndOtp(String phoneNumber, String otp);
}

