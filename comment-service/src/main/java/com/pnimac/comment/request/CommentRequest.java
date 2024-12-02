package com.pnimac.comment.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

	private String content;
	private Long fundraiserId;
	private String username;
	
}
