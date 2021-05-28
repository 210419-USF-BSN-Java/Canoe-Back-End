package com.canoetravel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_role_id")
	private Integer user_role_id;

	@Column(name = "user_role")
	private String user_role;

	public UserRole() {
	}

	public UserRole(Integer user_role_id, String user_role) {
		super();
		this.user_role_id = user_role_id;
		this.user_role = user_role;
	}

	public Integer getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
		result = prime * result + ((user_role_id == null) ? 0 : user_role_id.hashCode());
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
		UserRole other = (UserRole) obj;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		if (user_role_id == null) {
			if (other.user_role_id != null)
				return false;
		} else if (!user_role_id.equals(other.user_role_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserRole [user_role_id=" + user_role_id + ", user_role=" + user_role + "]";
	}

}
