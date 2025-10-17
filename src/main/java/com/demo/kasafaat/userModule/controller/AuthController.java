package com.demo.kasafaat.userModule.controller;

import com.demo.kasafaat.commonModule.api.ApiResponse;
import com.demo.kasafaat.commonModule.exception.InvalidOtpException;
import com.demo.kasafaat.userModule.exception.UserNotFoundException;
import com.demo.kasafaat.userModule.model.SampleModel;
import com.demo.kasafaat.userModule.model.UserDto;
import com.demo.kasafaat.userModule.model.UserModel;
import com.demo.kasafaat.userModule.services.AuthService;
import com.demo.kasafaat.userModule.services.OTPService;
import com.demo.kasafaat.userModule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    private OTPService otpService;

    @Autowired
    private UserService userService;


    @GetMapping("health_check")
    public ApiResponse<String> health_check(){
        return new ApiResponse<>(true, "Health check", "Auth Module running ok", null);
    }


    // Dummy endpoint to simulate fetching user
    @GetMapping("exception_check")
    public ApiResponse<UserDto> exceptionChecker(@RequestParam String phone) {
        if (Objects.equals(phone, "1234567890")) {
            // simulate not found
            throw new UserNotFoundException(phone);
        }
        // normally you would fetch from DB/service
        return new ApiResponse<>(true, "user dto fetched", new UserDto(1L, "Test User", phone, "test@example.com"), null);
    }


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

    // Step 1: Request OTP
    @PostMapping("request_otp")
    public ResponseEntity<ApiResponse<String>> requestOtp(@RequestParam String phoneNumber) {
        String otp = otpService.generateOtp(phoneNumber);
        return  ResponseEntity.ok(new ApiResponse<>(true, "OTP sent successfully for testing", otp, null));
    }

    // Step 2: Verify OTP & check user
    @PostMapping("/verify_otp")
    public ApiResponse<Object> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        boolean isValid = otpService.verifyOtp(phoneNumber, otp);

        if (!isValid) {
            throw new InvalidOtpException(); // handled by GlobalExceptionHandler
        }

        UserModel user = userService.findByPhoneNumber(phoneNumber);

        if (user == null) {
            // Return marker for client app to show registration screen
            return new ApiResponse<>(true, "OTP verified. New user", "NEW_USER", null);
        } else {
            // Return user details for existing user
            return new ApiResponse<>(true, "OTP verified. Existing user", user, null);
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
    public ApiResponse<UserModel> getUser(@RequestParam String phoneNumber){
        UserModel user = userService.findByPhoneNumber(phoneNumber);
        if (user == null){
            throw new UserNotFoundException(phoneNumber);
        }
        return new ApiResponse<>(true, "user found", user, null);
    }

    @GetMapping("get_all_users")
    public ApiResponse<List<UserModel>> getAllUser(){
       List<UserModel> userModelList= userService.getAllUser();
       return new ApiResponse<>(true, "user list", userModelList, null);
    }
}
