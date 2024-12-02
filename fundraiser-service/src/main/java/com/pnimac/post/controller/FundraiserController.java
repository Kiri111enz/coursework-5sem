package com.pnimac.post.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.pnimac.post.request.DonationRequest;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pnimac.post.dto.FunraiserDTO;
import com.pnimac.post.model.Fundraiser;
import com.pnimac.post.request.FundraiserRequest;
import com.pnimac.post.service.FundraiserService;

@RestController
@RequestMapping("/api/fundraiser")
public class FundraiserController {

    private final FundraiserService fundraiserService;
	private final ObjectMapper objectMapper;

    @Autowired
	public FundraiserController(FundraiserService fundraiserService, ObjectMapper objectMapper) {
		this.fundraiserService = fundraiserService;
		this.objectMapper = objectMapper;
	}
	
    @GetMapping("/getAllFundraisers")
    public List<FunraiserDTO> getAllFundraisers() {
    	List<Fundraiser> fundraisers = fundraiserService.getAllFundraisers();
    	return fundraisers.stream()
                .map(FunraiserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @PostMapping("/createFundraiser")
    public ResponseEntity<?> createFundraiser(@RequestBody String rawBody) throws Exception {
    	FundraiserRequest fundRaiserRequest = objectMapper.readValue(rawBody, FundraiserRequest.class);
    	Fundraiser fundraiser = new Fundraiser();
    	fundraiser.setTitle(fundRaiserRequest.getTitle());
    	fundraiser.setDescription(fundRaiserRequest.getBody());
    	fundraiser.setUsername(fundRaiserRequest.getUsername());
        fundraiser.setMoneyCurrent(new BigDecimal("0"));
        fundraiser.setMoneyGoal(new BigDecimal(fundRaiserRequest.getMoneyGoal()));
        fundraiser.setCreatedAt(Instant.now());
        FunraiserDTO createdPost = FunraiserDTO.fromEntity(fundraiserService.addFundraiser(fundraiser));
        return ResponseEntity.ok(createdPost);
    }

    @PutMapping("/updateFundraiser/{fundraiserId}")
    public ResponseEntity<?> updateFundraiser(@PathVariable Long fundraiserId,
                                              @RequestBody String rawBody) throws Exception {
        DonationRequest donation = objectMapper.readValue(rawBody, DonationRequest.class);
        BigDecimal donatedMoney = new BigDecimal(donation.getDonation());
        fundraiserService.updateFundraiser(fundraiserId, donatedMoney);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deleteFundraiser/{fundraiserId}")
    public ResponseEntity<Void> deleteFundraiser(@PathVariable Long fundraiserId) {
        fundraiserService.deleteFundraiser(fundraiserId);
        return ResponseEntity.noContent().build();
    }
}
