package com.demo.kasafaat.dao;

import com.demo.kasafaat.model.SampleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthDao  extends JpaRepository<SampleModel, Integer> {
}
