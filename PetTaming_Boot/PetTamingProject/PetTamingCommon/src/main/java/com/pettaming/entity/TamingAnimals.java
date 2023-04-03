package com.pettaming.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="taminganimals")
public class TamingAnimals {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer list_id;

	@Column(length = 45, nullable = false)
	private String animal_name;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user_id;

	@OneToOne
	@JoinColumn(name = "animalid")
	private Animals animalid;

	@Column(nullable = false)
	private Integer animal_status;

	@Column(nullable = false)
	private Integer animal_liking;

	@Column(length = 45, nullable = false)
	private String color_border;

	@Column(length = 45, nullable = false)
	private String  color_1;

	@Column(length = 45, nullable = false)
	private String color_2;

	@Column(length = 128, nullable = false)
	private Timestamp last_Access_time;	
	
	@Transient
	private action animalAction;

	@Transient
	private action animalMoveAction;

	@Transient
	private int count;
	
	public TamingAnimals() {
	}


	public TamingAnimals(Integer list_id, String animal_name, User user_id, Animals animalid, Integer animal_status,
			Integer animal_liking, String color_border, String color_1, String color_2, Timestamp last_Access_time) {
		super();
		this.list_id = list_id;
		this.animal_name = animal_name;
		this.user_id = user_id;
		this.animalid = animalid;
		this.animal_status = animal_status;
		this.animal_liking = animal_liking;
		this.color_border = color_border;
		this.color_1 = color_1;
		this.color_2 = color_2;
		this.last_Access_time = last_Access_time;
	}

	public Integer getList_id() {
		return list_id;
	}


	public void setList_id(Integer list_id) {
		this.list_id = list_id;
	}


	public String getAnimal_name() {
		return animal_name;
	}


	public void setAnimal_name(String animal_name) {
		this.animal_name = animal_name;
	}


	public User getUser_id() {
		return user_id;
	}


	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}


	public Animals getAnimalid() {
		return animalid;
	}


	public void setAnimalid(Animals animalid) {
		this.animalid = animalid;
	}


	public Integer getAnimal_status() {
		return animal_status;
	}


	public void setAnimal_status(Integer animal_status) {
		this.animal_status = animal_status;
	}


	public Integer getAnimal_liking() {
		return animal_liking;
	}


	public void setAnimal_liking(Integer animal_liking) {
		this.animal_liking = animal_liking;
	}

	public String getColor_border() {
		return color_border;
	}


	public void setColor_border(String color_border) {
		this.color_border = color_border;
	}


	public String getColor_1() {
		return color_1;
	}


	public void setColor_1(String color_1) {
		this.color_1 = color_1;
	}


	public String getColor_2() {
		return color_2;
	}


	public void setColor_2(String color_2) {
		this.color_2 = color_2;
	}


	public Timestamp getLast_Access_time() {
		return last_Access_time;
	}


	public void setLast_Access_time(Timestamp last_Access_time) {
		this.last_Access_time = last_Access_time;
	}


	@Override
	public String toString() {
		return "TamingAnimals [list_id=" + list_id + ", animal_name=" + animal_name + ", user_id=" + user_id
				+ ", animalid=" + animalid + ", animal_status=" + animal_status + ", animal_liking=" + animal_liking
				+ ", color_border=" + color_border + ", color_1=" + color_1 + ", color_2=" + color_2
				+ ", last_Access_time=" + last_Access_time + "]";
	}


	public action getAnimalAction() {
		return animalAction;
	}


	public void setAnimalAction(action animalAction) {
		this.animalAction = animalAction;
	}


	public action getAnimalMoveAction() {
		return animalMoveAction;
	}


	public void setAnimalMoveAction(action animalMoveAction) {
		this.animalMoveAction = animalMoveAction;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
}
