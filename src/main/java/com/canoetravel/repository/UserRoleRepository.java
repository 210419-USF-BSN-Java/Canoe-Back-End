package com.canoetravel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.canoetravel.entities.UserRole;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
	
	UserRole findByUserRole(String userRole);
}
