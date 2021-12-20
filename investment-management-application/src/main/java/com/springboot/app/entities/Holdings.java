package com.springboot.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "holdings")
public class Holdings implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "holdings_id")
	private int holdingsId;
	
	@Column(name = "holdings_name")
	private String holdingsName;
	
	@Column(name = "holding_value",nullable=false)
	private Double holdingValue=0.0;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "holdings")
	private List<FundsHoldings> fundsHoldings = new ArrayList<FundsHoldings>();
	
	public int getHoldingsId() {
		return holdingsId;
	}

	public void setHoldingsId(int holdingsId) {
		this.holdingsId = holdingsId;
	}

	public String getHoldingsName() {
		return holdingsName;
	}

	public void setHoldingsName(String holdingsName) {
		this.holdingsName = holdingsName;
	}

	public Double getHoldingValue() {
		return holdingValue;
	}

	public void setHoldingValue(Double holdingValue) {
		this.holdingValue = holdingValue;
	}
	
	public List<FundsHoldings> getFundsHoldings() {
		return fundsHoldings;
	}

	public void setFundsHoldings(List<FundsHoldings> fundsHoldings) {
		this.fundsHoldings = fundsHoldings;
	}
}
