package com.demo.kasafaat.addressModule.services;

import com.demo.kasafaat.addressModule.exception.AddressNotFoundException;
import com.demo.kasafaat.addressModule.model.AddressDTO;
import com.demo.kasafaat.addressModule.model.AddressModel;
import com.demo.kasafaat.addressModule.dao.AddressRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<AddressModel> getAddressesByUserId(String userPhoneNumber) {
        return addressRepository.findByUserPhoneNumber(userPhoneNumber);
    }

    public AddressModel addAddress(AddressModel address) {
        return addressRepository.save(address);
    }

    public AddressModel updateAddress(Long id, AddressDTO updated) {
        AddressModel existing = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(id));

        existing.setLabel(updated.getLabel());
        existing.setAddressLine(updated.getAddressLine());
        existing.setNearbyLandmark(updated.getNearbyLandmark());
        existing.setLatitude(updated.getLatitude());
        existing.setLongitude(updated.getLongitude());

        return addressRepository.save(existing);
    }

    public void deleteAddress(Long id) {
        if (!addressRepository.existsById(id)) {
            throw new AddressNotFoundException(id);
        }
        addressRepository.deleteById(id);
    }
}
