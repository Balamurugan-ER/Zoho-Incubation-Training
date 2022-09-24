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
		
		public Connection getConnection() throws CustomException
		{
			Connection connection;
			try {
				connection = DriverManager.getConnection(getCredentials("url"),getCredentials("username") ,getCredentials("password"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CustomException(e.getMessage());
			}
			return connection;
		}
		public void closeConnection(Connection connection) throws CustomException
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new CustomException(e.getMessage());
			}
		}
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
		try(
				Statement statement = Creds.INSTANCE.getConnection().createStatement();)
		{			
			boolean rescode = statement.execute(query);
			System.out.println("Query executed successfully");
			if(rescode)
			{
				ResultSet result = statement.getResultSet();
				ArrayList<Employee> employeeRecords = new ArrayList<>();
				while(result.next())
				{
					Employee employee = new Employee();
					employee.setEmpId(result.getInt(1));
					employee.setEmpName(result.getString(2));
					employee.setEmpPhone(result.getString(3));
					employee.setEmpEmail(result.getString(4));
					employee.setEmpDept(result.getString(5));
					employeeRecords.add(employee);
				}
				result.close();
				return employeeRecords;
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
		return executeQuery(createTableSql);		
	}

	//TODO :-2 Add 10 employee records 
	public static void addEntry(Employee employee) throws CustomException
	{
		String query = "INSERT INTO employee VALUES(?,?,?,?,?);";
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setInt(1, employee.getEmpId());
			prepareStatement.setString(2, employee.getEmpName());
			prepareStatement.setString(3, employee.getEmpPhone());
			prepareStatement.setString(4, employee.getEmpEmail());
			prepareStatement.setString(5, employee.getEmpDept());
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
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setString(1, name);
			System.out.println(prepareStatement);
			boolean rescode = prepareStatement.execute();
			if(rescode)
			{
				ResultSet result = prepareStatement.getResultSet();
				ArrayList<Employee> employeeRecords = new ArrayList<>();
				while(result.next())
				{
					Employee employee = new Employee();
					employee.setEmpId(result.getInt(1));
					employee.setEmpName(result.getString(2));
					employee.setEmpPhone(result.getString(3));
					employee.setEmpEmail(result.getString(4));
					employee.setEmpDept(result.getString(5));
					employeeRecords.add(employee);
				}
				result.close();
				return employeeRecords;
			}

		} catch (SQLException e) {

			throw new CustomException(e.getMessage());
		}
		return null;
	}
	//TODO 4 update the Values of an Employee
	public static void updateRecords(int empId,String key,String value) throws CustomException
	{
		String query = "UPDATE employee SET "+key+"=? WHERE emp_id =?;";
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setString(1, value);
			prepareStatement.setInt(2,empId);
			System.out.println(prepareStatement);
			prepareStatement.execute();
			//getNRecords(100);
			
		} catch (SQLException e) {
			
			throw new CustomException(e.getMessage());
		}
	}
	
	//TODO 6 Rep 5 Sorted by asc or des on any column
	public static Object getNRecords(String tableName,String columnName,String order,int limit) throws CustomException
	{
		//String query = "SELECT * from employee ORDER BY "+cName+" "+ asc+" LIMIT ? ;";
		String query = "SELECT * from "+tableName+" ORDER BY "+columnName+" "+ order+" LIMIT ? ;";
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setInt(1, limit);
			boolean rescode = prepareStatement.execute();
			if(rescode)
			{
				ResultSet result = prepareStatement.getResultSet();
				ArrayList<Employee> employeeRecords = new ArrayList<>();
				while(result.next())
				{
					Employee employee = new Employee();
					employee.setEmpId(result.getInt(1));
					employee.setEmpName(result.getString(2));
					employee.setEmpPhone(result.getString(3));
					employee.setEmpEmail(result.getString(4));
					employee.setEmpDept(result.getString(5));
					employeeRecords.add(employee);
				}
				result.close();
				return employeeRecords;
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}
		return null;
	}

	
	//TODO 7 Delete a record by given id
	public static int deleteRecord(int id) throws CustomException
	{
		String query = "delete from employee where emp_id=?";
		int rescode;
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setInt(1, id);
			rescode = prepareStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}
		return rescode;
	}
	//TODO 8 POJO for employee Rep 2,3,5,6

	//TODO 9 Create Dep table NAME,AGE as Foreign key
	public static void createDepTable() throws CustomException
	{
		String query= "CREATE TABLE Dependent (\n"
				+ "    ID int,\n"
				+ "    NAME VARCHAR(30),\n"
				+ "    RELATIONSHIP VARCHAR(30),\n"
				+ "    FOREIGN KEY (ID) REFERENCES employee(emp_id)\n"
				+ ");";
		executeQuery(query);
	}

	//TODO 10 ADD atleast 2 Records to dep table
	public static void AddRecordsDependent(Dependent dependent) throws CustomException
	{
		String query = "INSERT INTO Dependent VALUES(?,?,?);";
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setInt(1, dependent.getId());
			prepareStatement.setString(2, dependent.getName());
			prepareStatement.setString(3, dependent.getRelationShip());
			System.out.println(prepareStatement);
			prepareStatement.execute();

		} catch (SQLException e) {

			throw new CustomException(e.getMessage());			
		}
		
	}
	//TODO 11 Get Depend Record
	public static Object getRecordsDependent(String column ,Object value,boolean id) throws CustomException
	{
		//String query = "SELECT Dependent.*, employee.name FROM Dependent JOIN employee ON Dependent.id = employee.emp_id WHERE employee."+column+"="+value+";";
		String query = "SELECT Dependent.*, employee.name FROM Dependent JOIN employee ON Dependent.id = employee.emp_id WHERE employee."+column+"=?;";
		
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			if(!id)
			{
				prepareStatement.setString(1, (String) value);
			}
			else
			{
				prepareStatement.setInt(1, (Integer) value);
			}			
			System.out.println(prepareStatement);
			boolean rescode = prepareStatement.execute();
			if(rescode)
			{
				ResultSet result = prepareStatement.getResultSet();
				ArrayList<Dependent> dependentRecords = new ArrayList<>();
				while(result.next())
				{
					Dependent dependent = new Dependent();
					dependent.setId(result.getInt(1));
					dependent.setName(result.getString(2));
					dependent.setRelationShip(result.getString(3));
					dependent.setEmpName(result.getString(4));
					dependentRecords.add(dependent);
				}
				result.close();
				return dependentRecords;
			}

		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new CustomException(e.getMessage());
		}
		return null;
	}
	
	//TODO 12 GET First N employees name&emp as sorted asc
	public static Object getNRecordSDependent(int count) throws CustomException
	{
		String query = "SELECT Dependent.*, employee.name FROM Dependent JOIN employee ON Dependent.id = employee.emp_id LIMIT ?;";
		try(PreparedStatement prepareStatement = Creds.INSTANCE.getConnection().prepareStatement(query);)
		{
			prepareStatement.setInt(1, count);
			System.out.println(prepareStatement);
			boolean rescode = prepareStatement.execute();
			if(rescode)
			{
				ResultSet result = prepareStatement.getResultSet();
				ArrayList<Dependent> dependentRecords = new ArrayList<>();
				while(result.next())
				{
					Dependent dependent = new Dependent();
					dependent.setId(result.getInt(1));
					dependent.setName(result.getString(2));
					dependent.setRelationShip(result.getString(3));
					dependentRecords.add(dependent);
				}
				result.close();
				return dependentRecords;
			}

		} catch (SQLException e) {

			throw new CustomException(e.getMessage());
		}
		return null;
	}
}