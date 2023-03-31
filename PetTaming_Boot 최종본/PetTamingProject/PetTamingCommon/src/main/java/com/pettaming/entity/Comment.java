package com.pettaming.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

//댓글 Entity
@Entity
@Table(name = "Comments")
public class Comment extends BaseTime{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Posts posts;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(length = 1000, nullable = false)
	private String comments;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Comment parent;
	
	@OneToMany(mappedBy = "parent", orphanRemoval = true)
	private List<Comment> childrens = new ArrayList<>();	
	
	//부모 댓글 수정
	public void parentUpdate(Comment parent) {
		this.parent = parent;
	}
	
	public Comment(String comments) {
		this.comments = comments;
		this.parent = parent;
	}
	
	public boolean validateMember(User user) {
		return !this.user.equals(user);
	}
	
	public Comment() {
		
	}

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Comment getParent() {
		return parent;
	}

	public void setParent(Comment parent) {
		this.parent = parent;
	}

	public List<Comment> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Comment> childrens) {
		this.childrens = childrens;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", posts=" + posts + ", user=" + user + ", comments=" + comments
				+ ", parent=" + parent + ", childrens=" + childrens + "]";
	}

	public static Comment copyIdAndName(Comment comment2) {
		Comment comment = new Comment();
		comment.setComment_id(comment2.getComment_id());
		comment.setComments(comment2.getComments());
		comment.setPosts(comment2.getPosts());
		comment.setUser(comment2.getUser());
		comment.setParent(comment2.getParent());
		return comment;
	}
	
	public static Comment copyIdAndName(Comment comment, String name) {
		Comment comments = new Comment();
		comments.setComment_id(comments.getComment_id());
		comments.setComments(comment.getComments());
		comments.setPosts(comment.getPosts());
		comments.setUser(comment.getUser());
		comments.setParent(comment.getParent());
		return comments;
	}
	
}
