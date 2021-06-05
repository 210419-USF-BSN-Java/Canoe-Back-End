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

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "user_fname", nullable = false)
	private String userFname;

	@Column(name = "user_lname")
	private String userLname;

	@Column(name = "user_email", unique = true, nullable = false)
	private String userEmail;

	@Column(name = "user_login", unique = true, nullable = false)
	private String userLogin;

	@Column(name = "user_login_password", nullable = false)
	private String userLoginPassword;

	@Column(name = "is_active")
	private boolean isActive;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_role_id", updatable = true, insertable = true)
	private UserRole userRoleId;

	public User() {
	}

	public User(Integer userId, String userFname, String userLname, String userEmail, String userLogin,
			String userLoginPassword, boolean isActive, UserRole userRoleId) {
		super();
		this.userId = userId;
		this.userFname = userFname;
		this.userLname = userLname;
		this.userEmail = userEmail;
		this.userLogin = userLogin;
		this.userLoginPassword = userLoginPassword;
		this.isActive = isActive;
		this.userRoleId = userRoleId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserFname() {
		return userFname;
	}

	public void setUserFname(String userFname) {
		this.userFname = userFname;
	}

	public String getUserLname() {
		return userLname;
	}

	public void setUserLname(String userLname) {
		this.userLname = userLname;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserLoginPassword() {
		return userLoginPassword;
	}

	public void setUserLoginPassword(String userLoginPassword) {
		this.userLoginPassword = userLoginPassword;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserRole getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(UserRole userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + ((userFname == null) ? 0 : userFname.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userLname == null) ? 0 : userLname.hashCode());
		result = prime * result + ((userLogin == null) ? 0 : userLogin.hashCode());
		result = prime * result + ((userLoginPassword == null) ? 0 : userLoginPassword.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (isActive != other.isActive)
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userFname == null) {
			if (other.userFname != null)
				return false;
		} else if (!userFname.equals(other.userFname))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userLname == null) {
			if (other.userLname != null)
				return false;
		} else if (!userLname.equals(other.userLname))
			return false;
		if (userLogin == null) {
			if (other.userLogin != null)
				return false;
		} else if (!userLogin.equals(other.userLogin))
			return false;
		if (userLoginPassword == null) {
			if (other.userLoginPassword != null)
				return false;
		} else if (!userLoginPassword.equals(other.userLoginPassword))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFname=" + userFname + ", userLname=" + userLname + ", userEmail="
				+ userEmail + ", userLogin=" + userLogin + ", userLoginPassword=" + userLoginPassword + ", isActive="
				+ isActive + ", userRoleId=" + userRoleId + "]";
	}

}
