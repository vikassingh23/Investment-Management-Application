package com.springboot.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "investors")
public class Investors implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "investors_id")
	private int investorsId;
	
	@Column(name = "investors_name")
	private String investorsName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "investors_funds", joinColumns = {
			@JoinColumn(referencedColumnName = "investors_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "funds_id") })
	private List<Funds> funds;

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

	public List<Funds> getFunds() {
		return funds;
	}

	public void setFunds(List<Funds> funds) {
		this.funds = funds;
	}
}
