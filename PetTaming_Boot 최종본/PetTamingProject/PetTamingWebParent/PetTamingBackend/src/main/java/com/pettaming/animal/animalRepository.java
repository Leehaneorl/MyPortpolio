package com.pettaming.animal;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.Animals;

//animal 테이블을 사용하는 리포지토리
@Repository
public interface animalRepository extends PagingAndSortingRepository<Animals , Integer> {

}
