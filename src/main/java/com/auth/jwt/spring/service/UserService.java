package com.auth.jwt.spring.service;

import com.auth.jwt.spring.entity.UserDAO;
import com.auth.jwt.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUserToDatabase(UserDAO userDAO){
        userRepository.save(userDAO);
    }

    public UserDAO findUserByUsername(String username){
        return userRepository.findByUserName(username);
    }

}
