package com.springboot.app.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.app.entities.Funds;

@Component
public interface BusinessService {

	double calculateTotalMarketValue(Funds fund, List<Integer> exclusionHoldingList);
	
}
