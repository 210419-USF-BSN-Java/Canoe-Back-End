package com.canoetravel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;

	@Column(name = "user_fname", nullable = false)
	private String user_fname;

	@Column(name = "user_lname")
	private String user_lname;

	@Column(name = "user_email", unique = true, nullable = false)
	private String user_email;

	@Column(name = "user_login", unique = true, nullable = false)
	private String user_login;

	@Column(name = "user_login_password", nullable = false)
	private String user_login_password;

	@Column(name = "is_active")
	private boolean is_active;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role_id", updatable = false, insertable = false)
	private UserRole user_role;
	
	@Column(name = "user_role_id")
	private int user_role_id;

}
