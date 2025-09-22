package com.demo.kasafaat.services;


import com.demo.kasafaat.dao.AuthDao;
import com.demo.kasafaat.model.RegisterModel;
import com.demo.kasafaat.model.SampleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    AuthDao authdao;

    public void signup(SampleModel model){
        authdao.save(model);
    }

    public List<SampleModel> login(){
       return authdao.findAll();
    }
}
