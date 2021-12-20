package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.dto.TotalMarketValueResponseDto;
import com.springboot.app.dto.TotalMarketValueRequestDto;
import com.springboot.app.exceptions.FundsException;
import com.springboot.app.exceptions.InvalidInputException;
import com.springboot.app.exceptions.InvestorException;
import com.springboot.app.services.InvestmentService;

@RestController
@RequestMapping(value="/api")
public class FetchInvestmentController {
	
	@Autowired
	private InvestmentService investmentService;
	
	@PostMapping(value = "/totalMarketValue", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TotalMarketValueResponseDto> getTotalMarketValue(@RequestBody TotalMarketValueRequestDto totalMarketValueRequestDto) 
		throws InvalidInputException, InvestorException, FundsException{
		TotalMarketValueResponseDto responseDto = investmentService.getTotalMarketValue(totalMarketValueRequestDto);
		return new ResponseEntity<TotalMarketValueResponseDto>(responseDto, HttpStatus.OK);
		
	}

}
