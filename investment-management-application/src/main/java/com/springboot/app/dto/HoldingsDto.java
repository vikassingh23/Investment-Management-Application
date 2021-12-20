package com.springboot.app.dto;

import java.io.Serializable;

public class HoldingsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int holdingsId;
	private String holdingsName;
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
	public HoldingsDto(int holdingsId, String holdingsName) {
		this.holdingsId = holdingsId;
		this.holdingsName = holdingsName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + holdingsId;
		result = prime * result + ((holdingsName == null) ? 0 : holdingsName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoldingsDto other = (HoldingsDto) obj;
		if (holdingsId != other.holdingsId)
			return false;
		if (holdingsName == null) {
			if (other.holdingsName != null)
				return false;
		} else if (!holdingsName.equalsIgnoreCase(other.holdingsName))
			return false;
		return true;
	}
}
