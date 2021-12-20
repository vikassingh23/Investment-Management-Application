package com.springboot.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.springboot.app.entities.Investors;

@Component
public interface InvestorService {
	double getTotalMarketValue(Integer id, List<Integer> exclusionHoldingList);
	Optional<Investors> getInvestorsById(int id);
}
