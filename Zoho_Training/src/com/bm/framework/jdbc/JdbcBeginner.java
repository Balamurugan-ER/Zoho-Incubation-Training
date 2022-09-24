/**
 * 
 */
package com.bm.framework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import com.bm.util.*;
/**
 * @author Balamurugan
 *
 */
public class JdbcBeginner 
{
	//TODO :-1 create table method 
	// Exp - Columns names

	public enum Creds
	{
		INSTANCE;
		private Properties credentials = new Properties();

		public String getCredentials(String key) {
			return (String)credentials.get(key);
		}

		public void setCredentials(String key,String value) {
			this.credentials.setProperty(key, value);
		}
		Creds()
		{
			setCredentials("url","jdbc:mysql://localhost:3306/incubationDB");
			setCredentials("username","root");
			setCredentials("password","Root@123");
		}
	}
	public static void createTable() throws CustomException
	{

		String createTableSql = "CREATE TABLE employee(emp_id int PRIMARY KEY,name varchar(30),mobile varchar(12),email varchar(40),department varchar(30));";
		executeQuery(createTableSql);

	}
	public static Object executeQuery(String query) throws CustomException
	{
		try(Connection connection = DriverManager.getConnection(Creds.INSTANCE.getCredentials("url"),Creds.INSTANCE.getCredentials("username") ,Creds.INSTANCE.getCredentials("password") );
				Statement statement = connection.createStatement();)
		{			
			boolean rescode = statement.execute(query);
			System.out.println("Query executed successfully");
			if(rescode)
			{
				ResultSet result = statement.getResultSet();

				LinkedHashMap<Integer,List<Object>> db = new LinkedHashMap<>();
				while(result.next())
				{
					List<Object> record = new ArrayList<Object>();
					record.add(result.getInt(1));
					record.add(result.getString(2));
					record.add(result.getString(3));
					record.add(result.getString(4));
					record.add(result.getString(5));
					db.put(result.getInt(1),record);
				}
				return db;
			}			
		}
		catch (SQLException  e) 
		{
			throw new CustomException(e.getMessage());
		}
		return null;
	}
	//TODO Complete the show columns
	public Object showColumns() throws CustomException
	{
		String createTableSql = "SHOW COLUMNS from employee";
		//Map<I,L> mapObject = (Map<I, L>) ExecuteQuery(createTableSql);
		return executeQuery(createTableSql);		
	}

	//TODO :-2 Add 10 employee records 
	public static void addEntry(int empId,String empName,String empMobile,String empEmail,String empDepartment) throws CustomException
	{
		String query = "INSERT INTO employee VALUES(?,?,?,?,?);";
		try(Connection connection = DriverManager.getConnection(Creds.INSTANCE.getCredentials("url"),Creds.INSTANCE.getCredentials("username") ,Creds.INSTANCE.getCredentials("password") );
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				)
		{

			prepareStatement.setInt(1, empId);
			prepareStatement.setString(2, empName);
			prepareStatement.setString(3, empMobile);
			prepareStatement.setString(4, empEmail);
			prepareStatement.setString(5, empDepartment);
			System.out.println(prepareStatement);
			prepareStatement.execute();

		} catch (SQLException e) {

			throw new CustomException(e.getMessage());			
		}
	}

	//TODO :-3 Get the Record for Given Employee Name
	public static Object getRecord(String name) throws CustomException
	{
		String query = "select * from employee where name=?;";
		try(Connection connection = DriverManager.getConnection(Creds.INSTANCE.getCredentials("url"),Creds.INSTANCE.getCredentials("username") ,Creds.INSTANCE.getCredentials("password") );
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				)
		{
			prepareStatement.setString(1, name);
			System.out.println(prepareStatement);
			boolean rescode = prepareStatement.execute();
			if(rescode)
			{
				ResultSet result = prepareStatement.getResultSet();

				LinkedHashMap<Integer,List<Object>> db = new LinkedHashMap<>();
				while(result.next())
				{
					List<Object> record = new ArrayList<Object>();
					record.add(result.getInt(1));
					record.add(result.getString(2));
					record.add(result.getString(3));
					record.add(result.getString(4));
					record.add(result.getString(5));
					db.put(result.getInt(1),record);
				}
				return db;
			}	
			//			if(rescode)
			//			{
			//				ResultSet result = prepareStatement.getResultSet();
			//				result.next();
			//				System.out.println("| EMP ID |  EMP NAME  | EMP MOBILE |   EMP MAILID   | EMP DEPARTMENT | ");
			//				System.out.format("%8s | %10s | %10s | %15s | %10s |\n",result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
			//			}

		} catch (SQLException e) {

			throw new CustomException(e.getMessage());
		}
		return null;
	}
	//TODO 4 update the Values of an Employee
	public static void updateRecords(int empId,String key,String value) throws CustomException
	{
		String query = "UPDATE employee SET "+key+"=? WHERE emp_id =?;";
		try(Connection connection = DriverManager.getConnection(Creds.INSTANCE.getCredentials("url"),Creds.INSTANCE.getCredentials("username") ,Creds.INSTANCE.getCredentials("password") );
				PreparedStatement prepareStatement = connection.prepareStatement(query);
				)
		{
			//prepareStatement.setString(1, key);
			prepareStatement.setString(1, value);
			prepareStatement.setInt(2,empId);
			System.out.println(prepareStatement);
			prepareStatement.execute();
			getNRecords(100);
			
		} catch (SQLException e) {
			
			throw new CustomException(e.getMessage());
		}
	}
	//TODO 5 Get all details of First N
	public static Object getNRecords(int nRows) throws CustomException
	{
		String query = "SELECT * FROM employee LIMIT ?;";
		try(Connection connect = DriverManager.getConnection(Creds.INSTANCE.getCredentials("url"),Creds.INSTANCE.getCredentials("username"),Creds.INSTANCE.getCredentials("password"));
				PreparedStatement prepareStatement = connect.prepareStatement(query);
				)
		{
			prepareStatement.setInt(1, nRows);		
			boolean rescode = prepareStatement.execute();
			if(rescode)
			{
				ResultSet result = prepareStatement.getResultSet();

				LinkedHashMap<Integer,List<Object>> db = new LinkedHashMap<>();
				while(result.next())
				{
					List<Object> record = new ArrayList<Object>();
					record.add(result.getInt(1));
					record.add(result.getString(2));
					record.add(result.getString(3));
					record.add(result.getString(4));
					record.add(result.getString(5));
					db.put(result.getInt(1),record);
				}
				return db;
			}	

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}
		return null;
	}
	//TODO 6 Rep 5 Sorted by asc or des on any column

	//TODO 7 Delete a record by given id

	//TODO 8 POJO for employee Rep 2,3,5,6

	//TODO 9 Create Dep table NAME,AGE as Foreign key

	//TODO 10 ADD atleast 2 Records to dep table

	//TODO 11 Get Depend Record

	//TODO 12 GET First N employees name&emp as sorted asc
}
















