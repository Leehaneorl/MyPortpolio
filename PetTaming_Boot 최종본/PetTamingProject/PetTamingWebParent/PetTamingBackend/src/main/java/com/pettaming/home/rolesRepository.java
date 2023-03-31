package com.pettaming.home;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.Roles;

//role 테이블을 사용하는 리포지토리
@Repository
public interface rolesRepository extends PagingAndSortingRepository<Roles, Integer> {

	//특정 유저의 권한을 모두 출력하기 위한 메서드
	@Query("SELECT r FROM Roles r WHERE r.role_user_id = :role_user_id")
	public List<Roles> findByUserId(@Param("role_user_id") Integer user_id);
	
	@Modifying
	@Query("DELETE FROM Roles r WHERE r.role_user_id = :role_user_id and r.role = :role")
	void delete(@Param("role_user_id") Integer user_id,@Param("role") String role);

	@Modifying
	@Query("DELETE FROM Roles r WHERE r.role_user_id = :role_user_id")
	void deleteByUserId(@Param("role_user_id") Integer id);
	
	@Modifying
	@Query("DELETE FROM Roles r WHERE r.role = :role_user")
	public void deleteByUserId_Friend(@Param("role_user")String string);

	@Query("SELECT r.role FROM Roles r WHERE r.role_user_id = :role_user_id")
	public List<String> RolefindByUserId(@Param("role_user_id") Integer user_id);
}
