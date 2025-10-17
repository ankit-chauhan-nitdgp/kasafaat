package com.demo.kasafaat.addressModule.controller;

import com.demo.kasafaat.addressModule.exception.AddressNotAddedException;
import com.demo.kasafaat.addressModule.exception.AddressNotFoundException;
import com.demo.kasafaat.addressModule.model.AddressDTO;
import com.demo.kasafaat.addressModule.model.AddressModel;
import com.demo.kasafaat.addressModule.services.AddressService;
import com.demo.kasafaat.commonModule.api.ApiResponse;
import com.demo.kasafaat.userModule.model.UserModel;
import com.demo.kasafaat.userModule.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {


    @Autowired
    AddressService addressService;

    @Autowired
    UserService userService;


    @GetMapping("/health_check")
    public ApiResponse<String> health_check(){
        return new ApiResponse<>(true, "Health check", " address module : running ok", null);
    }


    @GetMapping("/getAddresses")
    public ApiResponse<List<AddressModel>> getAddresses(@RequestParam String userPhoneNumber) {
        List<AddressModel> addresses = addressService.getAddressesByUserId(userPhoneNumber);
        return new ApiResponse<>(true, "Addresses fetched successfully", addresses, null);
    }

    @PostMapping("/addAddress")
    public ApiResponse<AddressModel> addAddress(@RequestBody AddressDTO addressDTO) {
        AddressModel address = new AddressModel();

        address.setUserPhoneNumber(addressDTO.getUserPhoneNumber());
        address.setLabel(addressDTO.getLabel());
        address.setAddressLine(address.getAddressLine());
        address.setNearbyLandmark(address.getNearbyLandmark());
        address.setLatitude(address.getLatitude());
        address.setLongitude(address.getLongitude());


        AddressModel newAddress = addressService.addAddress(address);
        if (newAddress == null){
            throw new AddressNotAddedException();
        }

        return new ApiResponse<>(true, "Address added successfully", newAddress, null);
    }

    @PutMapping("/updateAddress")
    public ApiResponse<AddressModel> updateAddress(@RequestParam Long id, @RequestBody AddressDTO updated) {
        AddressModel saved = addressService.updateAddress(id, updated);
        return new ApiResponse<>(true, "Address updated successfully", saved, null);
    }

    @PutMapping("/markDefault")
    public ApiResponse<UserModel> markDefault(@RequestParam String phoneNumber, @RequestParam Long defaultAddressId) {
        UserModel user = userService.updateDefaultAddress(phoneNumber, defaultAddressId);
        return new ApiResponse<>(true, "Default address changed successfully", user, null);
    }

    @DeleteMapping("/deleteAddress")
    public ApiResponse<String> deleteAddress(@RequestParam Long id) {
        addressService.deleteAddress(id);
        return new ApiResponse<>(true, "Address deleted successfully", "DELETED", null);
    }
}