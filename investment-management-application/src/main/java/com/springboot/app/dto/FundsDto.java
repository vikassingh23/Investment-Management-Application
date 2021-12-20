package com.springboot.app.dto;

import java.io.Serializable;

public class FundsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int fundsId;
	private String fundsName;
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
	public FundsDto(int fundsId, String fundsName) {
		this.fundsId = fundsId;
		this.fundsName = fundsName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fundsId;
		result = prime * result + ((fundsName == null) ? 0 : fundsName.hashCode());
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
		FundsDto other = (FundsDto) obj;
		if (fundsId != other.fundsId)
			return false;
		if (fundsName == null) {
			if (other.fundsName != null)
				return false;
		} else if (!fundsName.equalsIgnoreCase(other.fundsName))
			return false;
		return true;
	}
	
	
}