package com.demo.kasafaat.addressModule.dao;

import com.demo.kasafaat.addressModule.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    List<AddressModel> findByUserPhoneNumber(String userPhoneNumber);
}
