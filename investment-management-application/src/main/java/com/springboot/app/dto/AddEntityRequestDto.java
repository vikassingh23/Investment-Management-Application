package com.springboot.app.dto;

import java.io.Serializable;

public class AddEntityRequestDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String parent;
	private String child;
	private int level;
	private int edge;
	private double holdingValue;
	
	public String getParent() {
		return parent;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public String getChild() {
		return child;
	}
	
	public void setChild(String child) {
		this.child = child;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getEdge() {
		return edge;
	}
	
	public void setEdge(int edge) {
		this.edge = edge;
	}

	public double getHoldingValue() {
		return holdingValue;
	}

	public void setHoldingValue(double holdingValue) {
		this.holdingValue = holdingValue;
	}
}
