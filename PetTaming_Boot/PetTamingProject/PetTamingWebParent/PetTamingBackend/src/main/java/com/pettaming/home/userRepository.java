package com.pettaming.home;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.User;

//user 테이블을 사용하는 리포지토리
@Repository
public interface userRepository extends PagingAndSortingRepository<User, Integer> {

	//해당 이름의 유저의 객체를 출력하는 메서드
	@Query("SELECT u FROM User u WHERE u.email = :username")
	User getUserByName(@Param("username") String username);
	
    @Query("Select u From User u WHERE u.email = :email")
	User findByEmail(@Param("email") String email);
    
    @Modifying
	@Query("DELETE FROM Roles r WHERE r.role_user_id = :role_user_id and r.role = :role")
	void delete(@Param("role_user_id") Integer user_id,@Param("role") String role);
    
    @Query("SELECT u FROM User u WHERE CONCAT(u.user_id,' ',u.username,' ',u.email) LIKE %?1%")
    public Page<User> findAll(String keyword, Pageable pageable);

}
