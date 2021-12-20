package com.springboot.app.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.app.entities.Funds;
import com.springboot.app.entities.FundsHoldings;
import com.springboot.app.services.BusinessService;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Override
	public double calculateTotalMarketValue(Funds fund, List<Integer> exclusionHoldingList) {
		double marketValueforFund = 0.0;
		List<FundsHoldings> fundsHoldings = fund.getFundsHoldings();
		if (fundsHoldings != null && fundsHoldings.size() != 0) {
			List<FundsHoldings> applicableFundsHoldings = fundsHoldings.stream().filter(s -> !exclusionHoldingList.contains(s.getFundsHoldingsId())).collect(Collectors.toList());
			for(FundsHoldings fundsHolding : applicableFundsHoldings) {
				int quantity = fundsHolding.getQuantity();
				double holdingValue = fundsHolding.getHoldings().getHoldingValue();
				marketValueforFund += quantity * holdingValue;
			}
		}
		return marketValueforFund;
	}
	
}
