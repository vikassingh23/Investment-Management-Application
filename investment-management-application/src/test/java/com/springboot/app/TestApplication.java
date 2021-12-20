package com.springboot.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.app.controllers.InvestmentController;
import com.springboot.app.dao.InvestmentDao;
import com.springboot.app.dto.AddEntityRequestDto;
import com.springboot.app.dto.AddEntityResponseDto;
import com.springboot.app.dto.TotalMarketValueRequestDto;
import com.springboot.app.dto.TotalMarketValueResponseDto;
import com.springboot.app.exceptions.FundsException;
import com.springboot.app.exceptions.InvalidInputException;
import com.springboot.app.exceptions.InvestorException;
import com.springboot.app.services.FundService;
import com.springboot.app.services.InvestmentService;
import com.springboot.app.services.InvestorService;
import com.springboot.app.services.implementation.InvestmentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestApplication {
	
	@Mock
	private InvestmentService investmentService;
	
	@InjectMocks
	private InvestmentServiceImpl investmentServiceImpl;
	
	@Mock
	private InvestmentDao investmentDao;

	@Mock
	private InvestorService investorService;

	@Mock
	private FundService fundService;
	
	@InjectMocks
	private InvestmentController investmentController;
	
	@Test
	public void validateNodeApi() throws JsonProcessingException, InvalidInputException {
		
		AddEntityRequestDto requestDto = new AddEntityRequestDto();
		requestDto.setParent("A");
		requestDto.setChild("B");
		requestDto.setLevel(0);
		requestDto.setEdge(10);
		requestDto.setHoldingValue(10.0);
		
		ResponseEntity<AddEntityResponseDto> response = investmentController.addEntity(requestDto);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void validateNodeApiLevel1() throws JsonProcessingException, InvalidInputException {
		
		AddEntityRequestDto requestDto = new AddEntityRequestDto();
		requestDto.setParent("B");
		requestDto.setChild("C");
		requestDto.setLevel(1);
		requestDto.setEdge(10);
		requestDto.setHoldingValue(10.0);
		
		ResponseEntity<AddEntityResponseDto> response = investmentController.addEntity(requestDto);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	public void validateNodeApiLevel2() throws JsonProcessingException, InvalidInputException {
		
		AddEntityRequestDto requestDto = new AddEntityRequestDto();
		requestDto.setParent("B");
		requestDto.setChild("C");
		requestDto.setLevel(2);
		requestDto.setEdge(10);
		requestDto.setHoldingValue(20.0);
		
		ResponseEntity<AddEntityResponseDto> response = investmentController.addEntity(requestDto);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test(expected = InvalidInputException.class)
	public void validateNodeApiException() throws JsonProcessingException, InvalidInputException {
		ResponseEntity<AddEntityResponseDto> response = investmentController.addEntity(null);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test(expected = InvalidInputException.class)
	public void validateGetTotalMarketValue() throws InvalidInputException, InvestorException, FundsException {
		TotalMarketValueRequestDto totalMarketValueRequestDto = new TotalMarketValueRequestDto();
		totalMarketValueRequestDto.setFundsId(2);
		totalMarketValueRequestDto.setInvestorsId(1);
		
		TotalMarketValueResponseDto responseDto = new TotalMarketValueResponseDto();
		responseDto.setTotalMarketValueByFunds(200.0);
		responseDto.setTotalMarketValueByInvestor(200.0);
		
		TotalMarketValueResponseDto response = investmentServiceImpl.getTotalMarketValue(totalMarketValueRequestDto);
		assertEquals(responseDto.getTotalMarketValueByFunds(), response.getTotalMarketValueByFunds());
		assertEquals(responseDto.getTotalMarketValueByInvestor(), response.getTotalMarketValueByInvestor());
		
	}
	
	

}
