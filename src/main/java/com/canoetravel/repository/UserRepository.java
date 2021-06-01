package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.canoetravel.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUserLogin(String userLogin);
	User findByUserEmail(String userEmail);
	User findByUserLoginAndUserLoginPassword(String login, String password);

//	@Query("update canoe_travel.users u set u.user_fname = ?1, u.u.user_lname = ?2, u.user_email = ?3 where u.user_id = ?4")
//	User updateUserInfo(String firstname, String lastname, String email, Integer userId);
}
