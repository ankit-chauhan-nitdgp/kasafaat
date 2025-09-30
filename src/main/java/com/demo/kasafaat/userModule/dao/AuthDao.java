package com.demo.kasafaat.userModule.dao;

import com.demo.kasafaat.userModule.model.SampleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthDao  extends JpaRepository<SampleModel, Integer> {
}
