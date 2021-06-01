package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.canoetravel.entities.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserLogin(String userLogin);
	User findByUserEmail(String userEmail);
	User findByUserLoginAndUserLoginPassword(String login, String password);

}
