package com.springboot.app.dto;

import java.io.Serializable;
import java.util.Set;

public class AddEntityResponseDto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private InvestorsDto investor;
	private Set<FundsDto> funds;
	private Set<HoldingsDto> holdings;
	public InvestorsDto getInvestor() {
		return investor;
	}
	public void setInvestor(InvestorsDto investor) {
		this.investor = investor;
	}
	public Set<FundsDto> getFunds() {
		return funds;
	}
	public void setFunds(Set<FundsDto> funds) {
		this.funds = funds;
	}
	public Set<HoldingsDto> getHoldings() {
		return holdings;
	}
	public void setHoldings(Set<HoldingsDto> holdings) {
		this.holdings = holdings;
	}
}
