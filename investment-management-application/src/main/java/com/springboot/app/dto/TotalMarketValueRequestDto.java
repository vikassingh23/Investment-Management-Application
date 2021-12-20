package com.springboot.app.dto;

import java.io.Serializable;
import java.util.List;

public class TotalMarketValueRequestDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer fundsId;
	private Integer investorsId;
	List<Integer> exclusionHoldingList;
	
	public Integer getFundsId() {
		return fundsId;
	}
	
	public void setFundsId(Integer fundsId) {
		this.fundsId = fundsId;
	}
	
	public Integer getInvestorsId() {
		return investorsId;
	}
	
	public void setInvestorsId(Integer investorsId) {
		this.investorsId = investorsId;
	}
	
	public List<Integer> getExclusionHoldingList() {
		return exclusionHoldingList;
	}
	
	public void setExclusionHoldingList(List<Integer> exclusionHoldingList) {
		this.exclusionHoldingList = exclusionHoldingList;
	}
}
