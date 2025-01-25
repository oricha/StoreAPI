package com.kmuniz.storeapi.web;


import com.kmuniz.storeapi.domain.User;
import com.kmuniz.storeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/get", produces = "application/json")
    public User getUserById(String userName ){
        return userService.getUserByName(userName);
    }


}
