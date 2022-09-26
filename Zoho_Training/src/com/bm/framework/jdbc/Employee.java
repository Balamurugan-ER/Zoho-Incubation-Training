/**
 * 
 */
package com.bm.framework.jdbc;

import java.io.Serializable;

/**
 * @author Balamurugan
 *
 */
public class Employee implements Serializable 
{
	private int empId;
	private String empName;
	private String empPhone;
	private String empEmail;
	private String empDept;
	public int getEmpId() 
	{
		return empId;
	}
	public void setEmpId(int empId) 
	{
		this.empId = empId;
	}
	public String getEmpName() 
	{
		return empName;
	}
	public void setEmpName(String empName) 
	{
		this.empName = empName;
	}
	public String getEmpPhone() 
	{
		return empPhone;
	}
	public void setEmpPhone(String empPhone) 
	{
		this.empPhone = empPhone;
	}
	public String getEmpEmail() 
	{
		return empEmail;
	}
	public void setEmpEmail(String empEmail) 
	{
		this.empEmail = empEmail;
	}
	public String getEmpDept() 
	{
		return empDept;
	}
	public void setEmpDept(String empDept) 
	{
		this.empDept = empDept;
	}	
	public String toString()
	{
		return "{ "+getEmpId()+" , "+getEmpName()+" , "+getEmpPhone()+" , "+getEmpEmail()+" , "+getEmpDept()+" }";
	}
}
