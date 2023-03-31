package com.pettaming.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTime {
	
	@CreatedDate
	private LocalDateTime createDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@CreationTimestamp
	private LocalDate now;
	

	public LocalDateTime getCreateDate() {
		return createDate;
	}


	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

    //작성일
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

    //수정일
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

    //현재 시간
	public LocalDate getNow() {
		return now;
	}


	public void setNow(LocalDate now) {
		this.now = now;
	}
	
	
	
	

	
	

}
