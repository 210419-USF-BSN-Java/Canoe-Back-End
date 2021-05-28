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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	
	@Column(name="user_fname", nullable=false)
	private String user_fname;
	
	@Column(name="user_lname")
	private String user_lname;
	
	@Column(name="user_email", unique=true, nullable=false)
	private String user_email;
	
	@Column(name="user_login", unique=true, nullable=false)
	private String user_login;
	
	@Column(name="user_login_password", nullable=false)
	private String user_login_password;
	
	@Column(name="is_active")
	private boolean is_active;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_role_id", updatable = false, insertable = false)
	private UserRole user_role_id;
	
	public User() {}

	public User(Integer user_id, String user_fname, String user_lname, String user_email, String user_login,
			String user_login_password, boolean is_active, UserRole user_role_id) {
		super();
		this.user_id = user_id;
		this.user_fname = user_fname;
		this.user_lname = user_lname;
		this.user_email = user_email;
		this.user_login = user_login;
		this.user_login_password = user_login_password;
		this.is_active = is_active;
		this.user_role_id = user_role_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_fname() {
		return user_fname;
	}

	public void setUser_fname(String user_fname) {
		this.user_fname = user_fname;
	}

	public String getUser_lname() {
		return user_lname;
	}

	public void setUser_lname(String user_lname) {
		this.user_lname = user_lname;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_login() {
		return user_login;
	}

	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}

	public String getUser_login_password() {
		return user_login_password;
	}

	public void setUser_login_password(String user_login_password) {
		this.user_login_password = user_login_password;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public UserRole getUser_role_id() {
		return user_role_id;
	}

	public void setUser_role_id(UserRole user_role_id) {
		this.user_role_id = user_role_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (is_active ? 1231 : 1237);
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_fname == null) ? 0 : user_fname.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_lname == null) ? 0 : user_lname.hashCode());
		result = prime * result + ((user_login == null) ? 0 : user_login.hashCode());
		result = prime * result + ((user_login_password == null) ? 0 : user_login_password.hashCode());
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
		User other = (User) obj;
		if (is_active != other.is_active)
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_fname == null) {
			if (other.user_fname != null)
				return false;
		} else if (!user_fname.equals(other.user_fname))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_lname == null) {
			if (other.user_lname != null)
				return false;
		} else if (!user_lname.equals(other.user_lname))
			return false;
		if (user_login == null) {
			if (other.user_login != null)
				return false;
		} else if (!user_login.equals(other.user_login))
			return false;
		if (user_login_password == null) {
			if (other.user_login_password != null)
				return false;
		} else if (!user_login_password.equals(other.user_login_password))
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
		return "User [user_id=" + user_id + ", user_fname=" + user_fname + ", user_lname=" + user_lname
				+ ", user_email=" + user_email + ", user_login=" + user_login + ", user_login_password="
				+ user_login_password + ", is_active=" + is_active + ", user_role_id=" + user_role_id + "]";
	}

}
