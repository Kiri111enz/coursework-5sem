package com.pnimac.comment.dto;

import java.util.Date;

import com.pnimac.comment.model.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

	private Long id;
	private String content;
	private Long fundraiserId;
	private String username;
	private Date createdAt;

	public CommentDTO() {
	}

	public static CommentDTO fromEntity(Comment comment) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setFundraiserId(comment.getFundraiserId());
		commentDTO.setContent(comment.getContent());
		commentDTO.setUsername(comment.getUsername());
		commentDTO.setCreatedAt(comment.getCreatedAt());
		return commentDTO;
	}
}
