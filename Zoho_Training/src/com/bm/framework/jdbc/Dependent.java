package com.bm.framework.jdbc;

public class Dependent 
{
	private int id;
	private String name;
	private String relationShip;
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getRelationShip() 
	{
		return relationShip;
	}
	public void setRelationShip(String relationShip) 
	{
		this.relationShip = relationShip;
	}
	public String toString()
	{
		return "{ "+getId()+" , "+getName()+" , "+getRelationShip()+" , "+getEmpName()+" }";
	}
}
