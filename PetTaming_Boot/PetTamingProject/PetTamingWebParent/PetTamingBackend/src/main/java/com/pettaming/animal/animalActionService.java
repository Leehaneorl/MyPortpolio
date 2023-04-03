package com.pettaming.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pettaming.entity.Animals;
import com.pettaming.entity.Color;
import com.pettaming.entity.TamingAnimals;
import com.pettaming.entity.action;

//컨트롤러로 동물 관련 기능을 보내기위한 서비스 
@Service
public class animalActionService {
	
	//애니멀 액션관련 기능을 받아오는 DAO
	private animalActionDAO AnimalDAO = new animalActionDAO();
	
	//animal 객체를 불러오기 위한 리포지토리
	@Autowired
	private animalRepository anre;

	//color 객체를 불러오기 위한 리포지토리
	@Autowired
	private colorRepository core;
	
	//동물(animal_id)_행동(actionNum)을 기반으로 애니멀 액션 테이블을 반환하는 메서드
    public action action_Select(Integer animal_id,String actionNum) throws Exception {
    	String animal = anre.findById(animal_id).get().getAnimal();
	    return AnimalDAO.get_animal(animal, actionNum);
    }
    
    //color테이블을 불러오는 메서드
    public List<Color> color_findAll(){
    	return (List<Color>) core.findAll();
    }

    //color테이블에서 원하는 색을 받아오는 메서드
	public Color color_findById(int i) {
		return core.findById(i).get();
	}

	//TamingAnimals 테이블에 저장된 모든 동물의 액션을 순차 저장하는 메서드
	public void getAllAnimalAction(List<TamingAnimals> allAnimals) throws Exception {
		int i = 1;
		for(TamingAnimals animal : allAnimals) {
			getAnimalAction(animal);
			animal.setCount(i++);
		}
	}

	//지정된 동물 객체의 액션을 저장하는 메서드
	public void getAnimalAction(TamingAnimals animal) throws Exception {
		
		Integer animal_id = animal.getAnimalid().getAnimalid();
		String animal_status = String.valueOf(animal.getAnimal_status());
		
		animal.setAnimalAction(action_Select(animal_id,animal_status));
		animal.setAnimalMoveAction(action_Select(animal_id, animal_status + "_action"));
	}

	//지정된 동물을 불러오는 메서드
	public Animals animal_findById(Integer animal_id) {
		return anre.findById(animal_id).get();
	}

	//animal 테이블의 모든 동물을 불러오는 메서드
	public Object animal_findAll() {
	return anre.findAll();
	}
	
}
