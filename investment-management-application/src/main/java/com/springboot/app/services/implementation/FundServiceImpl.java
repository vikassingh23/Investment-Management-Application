package com.springboot.app.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.dao.FundsRepository;
import com.springboot.app.entities.Funds;
import com.springboot.app.services.BusinessService;
import com.springboot.app.services.FundService;

@Service
public class FundServiceImpl implements FundService{
	
	@Autowired
	private FundsRepository fundsRepository;
	
	@Autowired
	private BusinessService businessService;

	@Override
	public double getTotalMarketValue(Integer id, List<Integer> exclusionHoldingList) {
		double totalMarketValue = 0.0;
		Optional<Funds> fundsData = getFundsById(id);
		if(fundsData.isPresent()) {
			totalMarketValue = businessService.calculateTotalMarketValue(fundsData.get(),exclusionHoldingList);
		}
		return totalMarketValue;
	}

	@Override
	public Optional<Funds> getFundsById(int id) {
		Optional<Funds> funds = fundsRepository.findById(id);
		return funds;
	}

}
