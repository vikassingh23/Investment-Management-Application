package com.springboot.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "funds_holdings")
public class FundsHoldings implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fundsHoldingsId")
	private int fundsHoldingsId;
	
	@ManyToOne
	@JoinColumn(name = "funds_id")
	private Funds funds;

	@ManyToOne
	@JoinColumn(name = "holdings_id")
	private Holdings holdings;

	@Column
	private int quantity=0;

	public int getFundsHoldingsId() {
		return fundsHoldingsId;
	}

	public void setFundsHoldingsId(int fundsHoldingsId) {
		this.fundsHoldingsId = fundsHoldingsId;
	}

	public Funds getFunds() {
		return funds;
	}

	public void setFunds(Funds funds) {
		this.funds = funds;
	}

	public Holdings getHoldings() {
		return holdings;
	}

	public void setHoldings(Holdings holdings) {
		this.holdings = holdings;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
