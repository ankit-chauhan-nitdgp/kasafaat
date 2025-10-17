package com.demo.kasafaat.addressModule.controller;

import com.demo.kasafaat.addressModule.model.AddressModel;
import com.demo.kasafaat.addressModule.services.AddressService;
import com.demo.kasafaat.commonModule.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {


    @Autowired
    AddressService addressService;

    @GetMapping("/health_check")
    public ApiResponse<String> health_check(){
        return new ApiResponse<>(true, "Health check", " address module : running ok", null);
    }


    @GetMapping("/{userId}")
    public ApiResponse<List<AddressModel>> getAddresses(@PathVariable Long userId) {
        List<AddressModel> addresses = addressService.getAddressesByUserId(userId);
        return new ApiResponse<>(true, "Addresses fetched successfully", addresses, null);
    }

    @PostMapping
    public ApiResponse<AddressModel> addAddress(@RequestBody AddressModel address) {
        AddressModel saved = addressService.addAddress(address);
        return new ApiResponse<>(true, "Address added successfully", saved, null);
    }

    @PutMapping("/{id}")
    public ApiResponse<AddressModel> updateAddress(@PathVariable Long id, @RequestBody AddressModel updated) {
        AddressModel saved = addressService.updateAddress(id, updated);
        return new ApiResponse<>(true, "Address updated successfully", saved, null);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteAddress(@PathVariable Long id) {
        addressService.deleteAddress(id);
        return new ApiResponse<>(true, "Address deleted successfully", "DELETED", null);
    }
}