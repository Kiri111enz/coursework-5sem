package com.pnimac.comment.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@Entity
@Table(name = "comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
    @Column(name = "fundraiser_id")
	private Long fundraiserId;
    
	private String username;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	public Comment() {
	}

	public Comment(Long id, Long fundraiserId, String username, Date createdAt) {
		super();
		this.id = id;
		this.fundraiserId = fundraiserId;
		this.username = username;
		this.createdAt = createdAt;
	}

}
