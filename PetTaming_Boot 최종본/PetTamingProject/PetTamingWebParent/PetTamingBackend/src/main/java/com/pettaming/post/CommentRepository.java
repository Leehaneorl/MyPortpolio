package com.pettaming.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pettaming.entity.Comment;
import com.pettaming.entity.Roles;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {


	@Query("SELECT c FROM Comment c WHERE c.posts.post_id = :post_id")
	public List<Comment> findByPostId(@Param("post_id") Integer post_id);
	
	 @Modifying
	 @Query("DELETE FROM Comment c WHERE c.user.user_id = :user_id")
	 void deleteByCommetUserId(@Param("user_id")Integer id);
	

}
