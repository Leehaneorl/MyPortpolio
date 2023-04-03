package com.pettaming.entity;

public class animalLiking {


	private String liking;
	private Long count;
	private String color;
	
	public animalLiking(String liking, Long count, String color) {
		super();
		this.liking = liking;
		this.count = count;
		this.color = color;
	}
	
	public String getLiking() {
		return liking;
	}
	public void setLiking(String liking) {
		this.liking = liking;
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
