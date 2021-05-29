package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserLogin(String userLogin);
	User findByUserEmail(String userEmail);

}
