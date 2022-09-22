package com.bm.framework.bprogram;

public enum CarSingleton
{
	GET_INSTANCE("Car Master Blueprint");
	
	private String patternName;
	
	public String getPatternName() {
		return patternName;
	}
	
	public void setPatternName(String patternName) {
		this.patternName = patternName;
	}
	CarSingleton(String pName)
	{
		setPatternName(pName);
	}
}