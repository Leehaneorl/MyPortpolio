package com.pettaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer role_id;
	
	@Column(nullable = false)
	@JoinColumn(name = "user_id")
	private Integer role_user_id;

	@Column(length = 45, nullable = false)
	private String role;

	public Roles() {
	}
	
	public Roles(Integer role_user_id, String role) {
		this.role_user_id = role_user_id;
		this.role = role;
	}


	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getRole_user_id() {
		return role_user_id;
	}

	public void setRole_user_id(Integer role_user_id) {
		this.role_user_id = role_user_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
