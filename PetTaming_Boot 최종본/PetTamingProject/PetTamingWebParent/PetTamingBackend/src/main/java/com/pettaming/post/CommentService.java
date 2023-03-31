package com.pettaming.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pettaming.entity.Comment;

@Service
@Transactional
public class CommentService {
	
	@Autowired
	private CommentRepository CR;
		
	private List<Comment> listChildrenAll(List<Comment> commentUse, Comment parent, int id) {
		
		int cmsubLevel = id +1;
		List<Comment> children = parent.getChildrens();
		
		for(Comment subComment : children) {
			String name = "";
			for(int i = 0; i < cmsubLevel; i++) {
				name += " ";
			}
			
			name += subComment.getComments();
			
			commentUse.add(Comment.copyIdAndName(subComment, name));
			listChildrenAll(commentUse,subComment,cmsubLevel);
		}
		
		return commentUse;  
		
	}
	
	public List<Comment> higherComment(Integer post_id){
		
		List<Comment> AllComment = (List<Comment>) CR.findByPostId(post_id);
		List<Comment> commentUse = new ArrayList<Comment>();
		
		for(Comment comment : AllComment) {
			if(comment.getParent() == null) {
				commentUse.add(Comment.copyIdAndName(comment));
				List<Comment> children = comment.getChildrens();
				
				for(Comment subComment : children) {
					String name = "  " + subComment.getComments();
					Comment parent = subComment.getParent();
					
					commentUse.add(Comment.copyIdAndName(subComment, name));
					
					listChildrenAll(commentUse,subComment,1);
				}
			}
		}
		
		return commentUse;
	}

	public List<Comment> childrenAll(){
		
		List<Comment> lists = CR.findAll();
		
		return lists;
	}
	
	public List<Comment> CommentList(){
		
		return (List<Comment>) CR.findAll();
	}
	

	public void saveComment(Comment comment) {
		
		CR.save(comment);
		
	}
	
	public void deleteComment(Integer comment_id) {
		CR.deleteById(comment_id);
	}
	
	
	public Comment findByCommentId(Integer comment_id) {
		
		return CR.findById(comment_id).get();
	}
	
			

}
