package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User getUserByName(String nameUser){

        return new User();
    }
}
