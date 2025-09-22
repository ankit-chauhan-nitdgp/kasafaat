package com.demo.kasafaat.controller;

import com.demo.kasafaat.model.SampleModel;
import com.demo.kasafaat.model.UserModel;
import com.demo.kasafaat.services.AuthService;
import com.demo.kasafaat.services.OTPService;
import com.demo.kasafaat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    private OTPService otpService;

    @Autowired
    private UserService userService;


    @PostMapping("signup")
    public ResponseEntity<String> signup(){
//        authService.signup(model);
        return new ResponseEntity<>("success signup revert", HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<List<SampleModel>> login(){
        List<SampleModel> list = authService.login();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("health_check")
    public ResponseEntity<String> health_check(){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }


    // Step 1: Request OTP
    @PostMapping("request_otp")
    public ResponseEntity<String> requestOtp(@RequestParam String phoneNumber) {
        String otp = otpService.generateOtp(phoneNumber);
        return new ResponseEntity<>("OTP sent successfully (for testing: " + otp + ")", HttpStatus.OK);
    }

    // Step 2: Verify OTP & check user
    @PostMapping("verify_otp")
    public String verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        boolean isValid = otpService.verifyOtp(phoneNumber, otp);

        if (!isValid) {
            return "Invalid OTP";
        }

        UserModel user = userService.findByPhoneNumber(phoneNumber);
        if (user == null) {
            return "NEW_USER";
        } else {
            return user.getName();
        }
    }

    @PostMapping("register_new_user")
    public String registerUser(@RequestParam String phoneNumber, @RequestParam String name){
        UserModel user = userService.findByPhoneNumber(phoneNumber);
        if (user != null) {
            return "Phone Number already exists";
        }
        UserModel model = new UserModel();
        model.setName(name);
        model.setPhoneNumber(phoneNumber);
        UserModel newUser = userService.registerNewUser(model);
        if (newUser != null){
            return "User registered SuccessFully";
        }else {
            return "User registration Failed";
        }
    }

    @GetMapping("get_user")
    public UserModel getUser(@RequestParam String phoneNumber){
        return userService.findByPhoneNumber(phoneNumber);
    }

    @GetMapping("get_all_users")
    public List<UserModel> getAllUser(){
        return userService.getAllUser();
    }
}
