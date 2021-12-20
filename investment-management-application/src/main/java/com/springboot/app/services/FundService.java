package com.springboot.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.springboot.app.entities.Funds;

@Component
public interface FundService {
	double getTotalMarketValue(Integer id, List<Integer> exclusionHoldingList);
	Optional<Funds> getFundsById(int id);
}
