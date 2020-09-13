package com.auth.jwt.spring.service;

import com.auth.jwt.spring.entity.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDAO userDAO = userService.findUserByUsername(username);

        if(userDAO == null){
            throw new UsernameNotFoundException("User not found");
        } else {
            return new User(userDAO.getUserName(), userDAO.getPassword(), new ArrayList<>());
        }

        // Hard Coded User
        //return new User("foo", "foo", new ArrayList<>());
    }
}
