package com.pnimac.post.model;

import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "fundraiser")
public class Fundraiser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	@Column(precision = 15, scale = 2)
	private BigDecimal moneyGoal;

	@Column(precision = 15, scale = 2)
	private BigDecimal moneyCurrent;

	private String username;

	@Temporal(TemporalType.TIMESTAMP)
	private Instant createdAt;

}
