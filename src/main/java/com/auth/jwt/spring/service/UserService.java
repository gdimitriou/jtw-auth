package com.auth.jwt.spring.service;

import com.auth.jwt.spring.entity.User;
import com.auth.jwt.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUserToDatabase(User user){
        userRepository.save(user);
    }

}
