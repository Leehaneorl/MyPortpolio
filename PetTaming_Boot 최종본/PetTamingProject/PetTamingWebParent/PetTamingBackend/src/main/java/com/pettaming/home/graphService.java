package com.pettaming.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pettaming.animal.animalRepository;
import com.pettaming.animal.animalTamingRepository;
import com.pettaming.entity.Animals;
import com.pettaming.entity.animalColor;
import com.pettaming.entity.animalCount;
import com.pettaming.entity.animalLiking;
import com.pettaming.entity.animalStatusCount;

@Service
public class graphService {

	//animalTaming 테이블을 사용하기 위한 리포지토리
	@Autowired
	private animalTamingRepository aniTamRepo;

	@Autowired
	private animalRepository aniRepo;
	
	public List<animalCount> getAnimalCount() {
		
		List<animalCount> animalCountList = new ArrayList<>();
		List<Animals> animalList = (List<Animals>)aniRepo.findAll();
		
		
		for(Animals animal : animalList) {
			animalCount Count = new animalCount(animal.getAnimal(),aniTamRepo.countByAnimalid(animal.getAnimalid()));
			
			if(animal.getAnimalid() == 1)
				Count.setColor("Brown");
			else if(animal.getAnimalid() == 2)
				Count.setColor("Gray");
			
			animalCountList.add(Count);
		}

		
		return animalCountList;
	}

	public List<animalStatusCount> getAnimalStatusCount() {
		
		List<animalStatusCount> animalStatusCountList = new ArrayList<>();
		
		
		for(int i = 1; i <=9 ; i++) {
			animalStatusCount Count = null;
			
			switch(i) {
			case 1:
				Count = new animalStatusCount("평상시",aniTamRepo.countByAnimal_Status(1),"Red");
				break;
			case 2:
				Count = new animalStatusCount("기뻐요",aniTamRepo.countByAnimal_Status(2),"Orange");
				break;
			case 3:
				Count = new animalStatusCount("슬퍼요",aniTamRepo.countByAnimal_Status(3),"Yellow");
				break;
			case 4:
				Count = new animalStatusCount("배고파",aniTamRepo.countByAnimal_Status(4),"Green");
				break;
			case 5:
				Count = new animalStatusCount("식사중",aniTamRepo.countByAnimal_Status(5),"Skyblue");
				break;
			case 6:
				Count = new animalStatusCount("잠자기",aniTamRepo.countByAnimal_Status(6),"Darkblue");
				break;
			case 7:
				Count = new animalStatusCount("놀아줘",aniTamRepo.countByAnimal_Status(7),"Purple");
				break;
			case 8:
				Count = new animalStatusCount("간식줘",aniTamRepo.countByAnimal_Status(8),"Brown");
				break;
			case 9:
				Count = new animalStatusCount("가려워",aniTamRepo.countByAnimal_Status(9),"Gray");
				break;
			}
			animalStatusCountList.add(Count);
		}

		
		return animalStatusCountList;
	}

	public List<animalLiking> getAnimalanimalLikingCount() {
		
		List<animalLiking> animalLikingCountList = new ArrayList<>();
		
		
		for(int i = 1; i <=10 ; i++) {
			animalLiking Count = null;
			
			switch(i) {
			case 1:
				Count = new animalLiking("1",aniTamRepo.countByAnimal_Liking(1),"Red");
				break;
			case 2:
				Count = new animalLiking("2",aniTamRepo.countByAnimal_Liking(2),"Orange");
				break;
			case 3:
				Count = new animalLiking("3",aniTamRepo.countByAnimal_Liking(3),"Yellow");
				break;
			case 4:
				Count = new animalLiking("4",aniTamRepo.countByAnimal_Liking(4),"Green");
				break;
			case 5:
				Count = new animalLiking("5",aniTamRepo.countByAnimal_Liking(5),"Skyblue");
				break;
			case 6:
				Count = new animalLiking("6",aniTamRepo.countByAnimal_Liking(6),"Darkblue");
				break;
			case 7:
				Count = new animalLiking("7",aniTamRepo.countByAnimal_Liking(7),"Purple");
				break;
			case 8:
				Count = new animalLiking("8",aniTamRepo.countByAnimal_Liking(8),"Brown");
				break;
			case 9:
				Count = new animalLiking("9",aniTamRepo.countByAnimal_Liking(9),"Gray");
				break;
			case 10:
				Count = new animalLiking("10",aniTamRepo.countByAnimal_Liking(10),"Pink");
				break;
			}
			animalLikingCountList.add(Count);
		}

		
		return animalLikingCountList;
	}

	public List<animalColor> getAnimalanimalColorCount() {
		
		List<animalColor> animalColorCountList = new ArrayList<>();
		
		
		for(int i = 1; i <=12 ; i++) {
			animalColor Count = null;
			
			switch(i) {
			case 1:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Red"),"Red");
				break;
			case 2:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Orange"),"Orange");
				break;
			case 3:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Yellow"),"Yellow");
				break;
			case 4:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Green"),"Green");
				break;
			case 5:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Skyblue"),"Skyblue");
				break;
			case 6:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Blue"),"Blue");
				break;
			case 7:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Purple"),"Purple");
				break;
			case 8:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Brown"),"Brown");
				break;
			case 9:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Gray"),"Gray");
				break;
			case 10:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Teal"),"Teal");
				break;
			case 11:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("White"),"White");
				break;
			case 12:
				Count = new animalColor(aniTamRepo.countByAnimal_Color("Black"),"Black");
				break;
			}
			animalColorCountList.add(Count);
		}

		
		return animalColorCountList;
	}
	
}
