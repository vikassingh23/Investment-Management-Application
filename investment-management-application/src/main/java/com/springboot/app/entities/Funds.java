package com.springboot.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funds")
public class Funds implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "funds_id")
	private int fundsId;
	
	@Column(name = "funds_name")
	private String fundsName;
	
	@ManyToMany(mappedBy = "funds")
	private List<Investors> investors;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "funds")
	private List<FundsHoldings> fundsHoldings;

	public int getFundsId() {
		return fundsId;
	}

	public void setFundsId(int fundsId) {
		this.fundsId = fundsId;
	}

	public String getFundsName() {
		return fundsName;
	}

	public void setFundsName(String fundsName) {
		this.fundsName = fundsName;
	}

	public List<Investors> getInvestors() {
		return investors;
	}

	public void setInvestors(List<Investors> investors) {
		this.investors = investors;
	}
	
	public List<FundsHoldings> getFundsHoldings() {
		return fundsHoldings;
	}

	public void setFundsHoldings(List<FundsHoldings> fundsHoldings) {
		this.fundsHoldings = fundsHoldings;
	}
}
