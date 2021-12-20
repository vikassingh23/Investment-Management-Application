package com.springboot.app.enums;

public enum LevelEnum {	
	Level0(0),
	Level1(1),
	Level2(2);
	
	private int level;

	private LevelEnum(int level) {
		this.level = level;
	}
	
	public int getValue() {
		return level;
	}
}
