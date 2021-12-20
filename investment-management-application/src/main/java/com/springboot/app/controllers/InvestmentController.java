package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.dto.AddEntityResponseDto;
import com.springboot.app.dto.AddEntityRequestDto;
import com.springboot.app.dto.TotalMarketValueResponseDto;
import com.springboot.app.dto.TotalMarketValueRequestDto;
import com.springboot.app.exceptions.FundsException;
import com.springboot.app.exceptions.InvalidInputException;
import com.springboot.app.exceptions.InvestorException;
import com.springboot.app.services.InvestmentService;

@RestController
@RequestMapping(value="/api/investment")
public class InvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	@PostMapping(value = "/entity", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AddEntityResponseDto> addEntity(@RequestBody AddEntityRequestDto requestDto) throws InvalidInputException {
		if (requestDto == null || requestDto.getLevel() >= 3)
			throw new InvalidInputException("Kindly enter valid level");
		AddEntityResponseDto addEntityResponse = investmentService.addEntity(requestDto);
		return new ResponseEntity<>(addEntityResponse, HttpStatus.CREATED);
	}
	
	

}
