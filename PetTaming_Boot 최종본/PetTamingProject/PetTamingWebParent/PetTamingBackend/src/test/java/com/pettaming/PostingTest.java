package com.pettaming;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.pettaming.entity.Posts;
import com.pettaming.entity.User;
import com.pettaming.post.PostRepository;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PostingTest {
	
//	@Autowired
//	private PostRepository PR;
//	
//	@Test
//	public void CreatePostTests() {
//		
//		User user = new User();
//		
//		Posts post = new Posts();
//		
//		post.getPost_id();
//		post.setTitle("두번째 글");
//		post.setContent("재밌어요");
//		post.setView(0);
//		post.getCreateDate();
//		post.getModifiedDate();
//		
//		PR.save(post);
//		
//		System.out.println(post.toString());
//	
//		
//	}

}
