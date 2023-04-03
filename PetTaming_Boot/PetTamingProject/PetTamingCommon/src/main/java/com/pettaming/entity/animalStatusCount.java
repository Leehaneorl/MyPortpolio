package com.pettaming.entity;

public class animalStatusCount {

	private String status;
	private Long count;
	private String color;

	public animalStatusCount(String status, Long count, String color) {
		super();
		this.status = status;
		this.count = count;
		this.color = color;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
