package com.pettaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer color_id;
	
	@Column(length = 45, nullable = false)
	private String color;

	public Color() {
	}
	
	public Color(Integer color_id, String color) {
		this.color_id = color_id;
		this.color = color;
	}

	public Integer getColor_id() {
		return color_id;
	}

	public void setColor_id(Integer color_id) {
		this.color_id = color_id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	
}
