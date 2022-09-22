/**
 * 
 */
package com.bm.framework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author Balamurugan
 *
 */
public class JdbcBeginner 
{
	//TODO :-1 create table method 
	// Exp - Columns names
	public void createTable()
	{
		String CreateTableSQL = "create table EMPLOYEE(\r\n"+
				 "EMPLOYEE_ID int(3) primary key,\r\n"+
				 "NAME varchar(30) ,\r\n"+
				 "MOBILE int(12),\r\n"+
				 "EMAIL varchar(40),\r\n"+
				 "DEPARTMENT varchar(30),\r\n"+");";
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/incubationDB?useSSL=false", "root", "root");
				Statement statement = connection.createStatement();){
			
			statement.execute(CreateTableSQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//TODO :-2 Add 10 employee records 
	//
	
	//TODO :-3 Get the Record for Given Employee Name
	
	
	//TODO 4 update the Values of an Employee
	
	//TODO 5 Get all details of First N
	
	//TODO 6 Rep 5 Sorted by asc or des on any column
	
	//TODO 7 Delete a record by given id
	
	//TODO 8 POJO for employee Rep 2,3,5,6
	
	//TODO 9 Create Dep table NAME,AGE as Foreign key
	
	//TODO 10 ADD atleast 2 Records to dep table
	
	//TODO 11 Get Depend Record
	
	//TODO 12 GET First N employees name&emp as sorted asc
}
















