package com.pettaming.entity;

public class animalColor {

	private Long count;
	private String color;
	
	public animalColor( Long count, String color) {
		this.count = count;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
	
	
}
