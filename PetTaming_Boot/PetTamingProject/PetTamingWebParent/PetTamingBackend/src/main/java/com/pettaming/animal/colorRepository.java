package com.pettaming.animal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.Color;

//color 테이블을 사용하는 리포지토리
@Repository
public interface colorRepository extends CrudRepository<Color, Integer> {

}
