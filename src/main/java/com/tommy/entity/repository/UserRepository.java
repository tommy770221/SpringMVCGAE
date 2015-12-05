package com.tommy.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommy.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
