package com.pnimac.post.dto;

import java.time.Instant;

import com.pnimac.post.model.Fundraiser;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FunraiserDTO {

    private Long id;
	private String title;
	private String description;
	private String username;
	private String moneyCurrent;
	private String moneyGoal;
	private Instant createdAt;

	public FunraiserDTO() {
	}

	public static FunraiserDTO fromEntity(Fundraiser fundraiser) {
		FunraiserDTO funraiserDTO = new FunraiserDTO();
		funraiserDTO.setId(fundraiser.getId());
		funraiserDTO.setTitle(fundraiser.getTitle());
		funraiserDTO.setDescription(fundraiser.getDescription());
		funraiserDTO.setUsername(fundraiser.getUsername());
		funraiserDTO.setMoneyCurrent(fundraiser.getMoneyCurrent().toString());
		funraiserDTO.setMoneyGoal(fundraiser.getMoneyGoal().toString());
		funraiserDTO.setCreatedAt(fundraiser.getCreatedAt());
		return funraiserDTO;
	}

}
