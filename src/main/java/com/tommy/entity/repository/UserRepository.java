package com.tommy.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tommy.entity.User;

public interface UserRepository  extends JpaRepository<User, String>{

	//注意不需要跟 Entity User內屬性名字相同
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
}
