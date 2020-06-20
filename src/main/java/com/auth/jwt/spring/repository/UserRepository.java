package com.auth.jwt.spring.repository;

import com.auth.jwt.spring.entity.UserDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Integer> {

    UserDAO findByUserName(String username);

}
