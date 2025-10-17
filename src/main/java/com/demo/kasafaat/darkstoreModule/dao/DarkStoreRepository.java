package com.demo.kasafaat.darkstoreModule.dao;

import com.demo.kasafaat.darkstoreModule.model.DarkStoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DarkStoreRepository extends JpaRepository<DarkStoreModel, Long> {
    List<DarkStoreModel> findByActiveTrue();
}
