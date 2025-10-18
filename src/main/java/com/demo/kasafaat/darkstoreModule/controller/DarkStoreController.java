package com.demo.kasafaat.darkstoreModule.controller;

import com.demo.kasafaat.commonModule.api.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("darkstore")
public class DarkStoreController {

    @GetMapping("/health_check")
    public ApiResponse<String> health_check(){
        return new ApiResponse<>(true, "Health check", " dark store module : running ok", null);
    }

}