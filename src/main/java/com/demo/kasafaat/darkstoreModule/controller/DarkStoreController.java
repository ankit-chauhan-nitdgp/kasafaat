package com.demo.kasafaat.darkstoreModule.controller;

import com.demo.kasafaat.addressModule.exception.AddressNotAddedException;
import com.demo.kasafaat.commonModule.api.ApiResponse;
import com.demo.kasafaat.userModule.model.UserModel;
import com.demo.kasafaat.userModule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("darkstore")
public class DarkStoreController {


    @GetMapping("/health_check")
    public ApiResponse<String> health_check(){
        return new ApiResponse<>(true, "Health check", " dark store module : running ok", null);
    }

}