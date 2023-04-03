package com.pettaming.post;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pettaming.entity.Posts;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository PR;
	
	//가독성과 유지보수성을 위해 상수를 사용 Post 페이징 처리
    public static final int POST_PER_PAGE = 10;
    
    //게시물 전체 불러오기
	//게시물 페이징 처리 및 검색
	public Page<Posts> listByPage(String Keyword,int pageNum,String SortFields,String SortDirs){
			
		Sort Sorts = Sort.by(SortFields);
		
		Sorts = SortDirs.equals("asc") ? Sorts.ascending() : Sorts.descending();
		
		Pageable pageable = PageRequest.of(pageNum - 1,POST_PER_PAGE, Sorts);
		
		System.out.println(Sorts);
				
		if(Keyword != null) {
			return PR.findAll(Keyword,pageable);
		}
		return PR.findAll(pageable);
	}
	//게시물 저장	
	public void save(Posts post) {
		
		PR.save(post);
	}
    //게시물 상세보기
	public Posts findByPostId(Integer post_id) {
		return PR.findById(post_id).get();
	}
	
	//조회수 업데이트
	public Integer UpdateView(Integer post_id) {
		return PR.UpdateView(post_id);
	}
	
	//게시물 삭제
	public void deleteById(Integer post_id) {
		PR.deleteById(post_id);
		
	}	

}
