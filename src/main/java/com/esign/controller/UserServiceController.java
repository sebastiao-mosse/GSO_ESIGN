package com.esign.controller;
import java.util.List;

import com.esign.model.UserEntity;
import com.esign.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Component
@RequestMapping("/api/v1")
public class UserServiceController {
    @Autowired
    private UserRepository $user;
    @RequestMapping(value = "/utilizadores")
    public List<UserEntity> getUsers() {
        System.out.println("Am here");
        return (List<UserEntity>) $user.findAll();
    }
}
