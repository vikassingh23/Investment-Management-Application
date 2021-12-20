package com.springboot.app.services;

import org.springframework.stereotype.Component;

import com.springboot.app.dto.AddEntityResponseDto;
import com.springboot.app.dto.AddEntityRequestDto;
import com.springboot.app.dto.TotalMarketValueResponseDto;
import com.springboot.app.dto.TotalMarketValueRequestDto;
import com.springboot.app.exceptions.FundsException;
import com.springboot.app.exceptions.InvalidInputException;
import com.springboot.app.exceptions.InvestorException;

@Component
public interface InvestmentService {
	AddEntityResponseDto addEntity(AddEntityRequestDto requestDto);
	TotalMarketValueResponseDto getTotalMarketValue(TotalMarketValueRequestDto totalMarketValueRequestDto) throws InvalidInputException, InvestorException, FundsException;
}
