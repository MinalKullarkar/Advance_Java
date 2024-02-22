package com.jspiders.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springbootapp.pojo.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByNameAndPassword(String name, String password);


}
