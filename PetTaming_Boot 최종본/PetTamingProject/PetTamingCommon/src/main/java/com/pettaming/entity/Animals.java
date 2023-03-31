package com.pettaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animals")
public class Animals {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer animalid;

	@Column(length = 45, nullable = false)
	private String animal;

	public Animals() {
	}

	public Integer getAnimalid() {
		return animalid;
	}

	public void setAnimalid(Integer animalid) {
		this.animalid = animalid;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
}
