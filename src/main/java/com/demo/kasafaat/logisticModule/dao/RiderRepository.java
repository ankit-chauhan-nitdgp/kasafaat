package com.demo.kasafaat.logisticModule.dao;

import com.demo.kasafaat.logisticModule.model.RiderModel;
import com.demo.kasafaat.logisticModule.model.RiderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RiderRepository extends JpaRepository<RiderModel, Long> {
    List<RiderModel> findByStatus(RiderStatus status);
}
