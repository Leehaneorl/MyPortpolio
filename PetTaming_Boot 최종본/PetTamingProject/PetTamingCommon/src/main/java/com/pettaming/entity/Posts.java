package com.pettaming.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

//자유게시판 및 Q&A 게시판 Entity
@Table(name = "posts")
@Entity
public class Posts extends BaseTime{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer post_id;
	
	@Column(length = 45, nullable = false)
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false)
	private User user_id;
	
	//게시물 내용
	@Column(length = 1000, nullable = false)
	private String content;
	
	@OneToMany(mappedBy = "posts", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy("comment_id DESC")
	private List<Comment> comments;
		
	@Column(columnDefinition = "integer default 0", nullable = false)
	private Integer view;	
		
	public Posts() {
		
	}
	
	

	public Posts(String title, User user_id, String content, List<Comment> comments, Integer view) {
		super();
		this.title = title;
		this.user_id = user_id;
		this.content = content;
		this.comments = comments;
		this.view = view;
	}



	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}		

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
		
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}


	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "Posts [post_id=" + post_id + ", title=" + title + ", user_id=" + user_id + ", content=" + content
				+ ", comments=" + comments + ", view=" + view + "]";
	}	
	
}
