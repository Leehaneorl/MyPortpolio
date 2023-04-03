package com.pettaming.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.Posts;
import com.pettaming.entity.User;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Posts, Integer> {
	
	@Modifying
	@Query("UPDATE Posts p SET p.view = p.view + 1 where p.post_id = :post_id")
	int UpdateView(@Param("post_id") Integer postid);
	
	@Query("Select p FROM Posts p WHERE CONCAT(p.post_id,' ',p.createDate,' ',p.title) LIKE %?1%")
	public Page<Posts> findAll(String keyword,Pageable pageable);
	
	@Modifying
	@Query("DELETE FROM Posts p WHERE p.user_id.user_id = :user_id")
	void deleteByUserId(@Param("user_id")Integer id);
	
}
