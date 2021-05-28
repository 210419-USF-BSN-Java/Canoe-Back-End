package com.canoetravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.canoetravel.entities.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

}
