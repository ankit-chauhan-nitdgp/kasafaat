package com.demo.kasafaat.userModule.services;


import com.demo.kasafaat.userModule.dao.AuthDao;
import com.demo.kasafaat.userModule.model.SampleModel;
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
