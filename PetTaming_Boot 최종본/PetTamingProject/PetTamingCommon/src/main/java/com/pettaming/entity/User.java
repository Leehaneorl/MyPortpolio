package com.pettaming.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	@Column(length = 128, nullable = false, unique = true)
	private String email;

	@Column(length = 45, nullable = false)
	private String username;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	@Column(length = 128, nullable = true)
	private String photos;
	
	@Transient
	public String getPhotosImagePath() {
		if(user_id == null || photos == null) {
			return "/images/default.jpg";
		}
		return "/User-photos/" + this.user_id + "/" + this.photos;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	@OneToMany(mappedBy = "role_user_id", fetch = FetchType.EAGER)
	private Set<Roles> roles = new HashSet<>();

	
	public void addRole(Roles role) {
		this.roles.add(role);
	}
	
	public User() {
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", photos=" + photos + ", roles=" + roles + "]";
	}
	
	
	
}
