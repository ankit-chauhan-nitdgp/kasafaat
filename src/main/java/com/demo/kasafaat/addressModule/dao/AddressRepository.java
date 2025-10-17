package com.demo.kasafaat.addressModule.dao;

import com.demo.kasafaat.addressModule.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    List<AddressModel> findByUserId(Long userId);
}
