package com.pettaming.entity;

public class animalCount {
	
	private String animalName;
	private Long count;
	private String color;
	
	public animalCount(String animalName, Long count) {
		this.animalName = animalName;
		this.count = count;
	}
	
	public String getAnimalName() {
		return animalName;
	}
	
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
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
