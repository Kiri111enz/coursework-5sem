package com.pnimac.post.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FundraiserRequest {

	private String title;
	private String body;
	private String username;
	private String moneyGoal;
	
	public FundraiserRequest() {}
	
	public FundraiserRequest(String title, String body, String username, String moneyGoal) {
		this.title = title;
		this.body = body;
		this.username = username;
		this.moneyGoal = moneyGoal;
	}
	
}
