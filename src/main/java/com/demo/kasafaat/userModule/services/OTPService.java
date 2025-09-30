package com.demo.kasafaat.userModule.services;

import com.demo.kasafaat.userModule.dao.OTPDao;
import com.demo.kasafaat.userModule.model.OTPModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class OTPService {

    @Autowired
    private OTPDao otpdao;

    public String generateOtp(String phoneNumber) {
        // simple 6-digit random OTP
        String otp = String.format("%06d", new Random().nextInt(999999));

        OTPModel otpModel = new OTPModel();
        otpModel.setPhoneNumber(phoneNumber);
        otpModel.setOtp(otp);

        otpdao.save(otpModel);

        // Here you would normally send the OTP via SMS
        return otp; // for testing, returning OTP directly
    }

    public boolean verifyOtp(String phoneNumber, String otp) {
        OTPModel otpModel = otpdao.findByPhoneNumberAndOtp(phoneNumber, otp);

        if (otpModel != null) {
            otpdao.delete(otpModel); // delete after successful verification
            return true;
        }

        return false;
    }
}

