package com.springmvc.service;

import com.springmvc.entity.Newer;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by diwakar on 02/10/17.
 */
@Service
public class NewerService {

    @Autowired
    private NewerRepository newerRepository;

    public Newer getNewerById(Long id){
        if(id != null){
           return newerRepository.findOne(id);
        }else{
            return  null;
        }
    }
}
