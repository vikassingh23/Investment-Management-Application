package com.springboot.app.dto;

import java.io.Serializable;

public class InvestorsDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int investorsId;
	private String investorsName;
	public int getInvestorsId() {
		return investorsId;
	}
	public void setInvestorsId(int investorsId) {
		this.investorsId = investorsId;
	}
	public String getInvestorsName() {
		return investorsName;
	}
	public void setInvestorsName(String investorsName) {
		this.investorsName = investorsName;
	}
	public InvestorsDto(int investorsId, String investorsName) {
		this.investorsId = investorsId;
		this.investorsName = investorsName;
	}
	
}
