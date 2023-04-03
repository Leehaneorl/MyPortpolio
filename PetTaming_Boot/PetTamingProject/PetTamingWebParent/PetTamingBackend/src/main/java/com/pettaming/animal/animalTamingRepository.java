package com.pettaming.animal;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.TamingAnimals;

//animalTaming 테이블을 사용하는 리포지토리
@Repository
@EnableJpaRepositories
public interface animalTamingRepository extends PagingAndSortingRepository<TamingAnimals, Integer> {
	

	   @Query("SELECT count(t) FROM TamingAnimals t WHERE t.animalid.animalid = :animalid")
	   Long countByAnimalid(@Param("animalid")Integer animalid);
	   
	   @Query("SELECT count(t) FROM TamingAnimals t WHERE t.animal_status = :animal_status")
	   Long countByAnimal_Status(@Param("animal_status")Integer i);
	
	   @Query("SELECT count(t) FROM TamingAnimals t WHERE t.animal_liking = :animal_liking")
	   Long countByAnimal_Liking(@Param("animal_liking")Integer i);
	
	   @Query("SELECT count(t) FROM TamingAnimals t WHERE t.color_1 = :color or t.color_2 = :color or t.color_border = :color")
	   Long countByAnimal_Color(@Param("color")String string);
	  
	   @Query("SELECT t FROM TamingAnimals t WHERE t.user_id.user_id = :user_id") 
	   List<TamingAnimals> findByUserId(@Param("user_id")Integer user_id);
	   
	   @Modifying
	   @Query("DELETE FROM TamingAnimals t WHERE t.user_id.user_id = :user_id")
	   void deleteByUserId(@Param("user_id")Integer id);
	   
	   @Query("SELECT t FROM TamingAnimals t WHERE CONCAT(t.animal_name,' ',t.user_id.username) LIKE %?1%")
	   List<TamingAnimals> findByTitleContaining(String keyword);
}
