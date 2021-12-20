package com.springboot.app.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.dao.InvestorsRepository;
import com.springboot.app.entities.Funds;
import com.springboot.app.entities.Investors;
import com.springboot.app.services.BusinessService;
import com.springboot.app.services.InvestorService;

@Service
public class InvestorServiceImpl implements InvestorService{

	@Autowired
	private InvestorsRepository investorsRepository;
	
	@Autowired
	private BusinessService businessService;
	
	@Override
	public double getTotalMarketValue(Integer id, List<Integer> exclusionHoldingList) {
		double totalMarketValue = 0.0;
		Optional<Investors> investorsData = getInvestorsById(id);
		if (investorsData.isPresent()) {
			Optional<List<Funds>> funds = Optional.ofNullable(investorsData.get().getFunds());

			if (funds.isPresent() && funds.get().size() > 0) {
				for (Funds fund : funds.get()) {
					totalMarketValue = totalMarketValue
							+ businessService.calculateTotalMarketValue(fund, exclusionHoldingList);
				}
			}
		}
		return totalMarketValue;
	}

	@Override
	public Optional<Investors> getInvestorsById(int id) {
		Optional<Investors> investors = investorsRepository.findById(id);
		return investors;
	}

}
