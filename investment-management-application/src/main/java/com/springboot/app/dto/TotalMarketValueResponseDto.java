package com.springboot.app.dto;

public class TotalMarketValueResponseDto {
	
	private double totalMarketValueByInvestor;
	private double totalMarketValueByFunds;
	
	public double getTotalMarketValueByInvestor() {
		return totalMarketValueByInvestor;
	}
	public void setTotalMarketValueByInvestor(double totalMarketValueByInvestor) {
		this.totalMarketValueByInvestor = totalMarketValueByInvestor;
	}
	public double getTotalMarketValueByFunds() {
		return totalMarketValueByFunds;
	}
	public void setTotalMarketValueByFunds(double totalMarketValueByFunds) {
		this.totalMarketValueByFunds = totalMarketValueByFunds;
	}
}
