package com.bm.testrunner;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bm.framework.jdbc.*;
import com.bm.util.CustomException;
/**
 * @author Balamurugan
 *
 */
public class TestJdbc 
{
	private static void printRecord(ArrayList<Object> records)
	{ 
		int length = records.size();
		for(int i=0;i< length;i++)
		{
			logger.log(Level.INFO,"{0}",records.get(i));
		}
	}
	private static Logger logger = Logger.getLogger(TestJdbc.class.getName());
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		logger.log(Level.INFO,"1.Enter to Create Table\n"
				+ "2.Enter N records in Employee table\n"
				+ "3.Get Record for a given employee name\n"
				+ "4.Updating values in records\n"
				+ "5.Fetch N records from Emp table\n"
				+ "6.Fetch N records ordered\n"
				+ "7.Delete Record\n"
				+ "8.Create Dependent Table\n"
				+ "9.Add Entry in Dependent table\n"
				+ "10.List depenend record for given emp id\n"
				+ "11.Fetch N records from dependent table");
		try
		{
			while(flag)
			{
				logger.log(Level.INFO,"Enter your choice");
				int n = scan.nextInt();
				switch(n)
				{
				case 0:
				{
					flag = false;
					break;
				}
				case 1:
				{

					JdbcBeginner.createTable();
					logger.log(Level.INFO,"Created Succesfully1");
					break;
				}
				case 2:
				{
					logger.log(Level.INFO,"Enter no of records you want to add in Employee table");
					int count = scan.nextInt();
					for(int i=1;i<=count;i++)
					{
						Employee employee = new Employee();
						logger.log(Level.INFO,"Enter EmpId ");
						employee.setEmpId(scan.nextInt());
						scan.nextLine();
						logger.log(Level.INFO,"Enter Emp Name");
						employee.setEmpName(scan.nextLine());
						logger.log(Level.INFO,"Enter Emp mobile number");
						employee.setEmpPhone(scan.nextLine());
						logger.log(Level.INFO,"Enter Emp mail");
						employee.setEmpEmail(scan.nextLine());
						logger.log(Level.INFO,"Enter Emp Dept");
						employee.setEmpDept(scan.nextLine());
						JdbcBeginner.addEntry(employee);
					}
					break;
				}
				case 3:
				{
					logger.log(Level.INFO,"Enter name to find a complete record ");
					String name = scan.next();
					ArrayList<Object> employees = (ArrayList<Object>) JdbcBeginner.getRecord(name);
					printRecord(employees);
					break;
				}
				case 4:
				{
					logger.log(Level.INFO,"Enter Emp id To update the data");
					Employee employee = new Employee();
					employee.setEmpId(scan.nextInt());
					logger.log(Level.INFO,"Enter Choice : \n"
							+ "1.Modify Mobile\n"
							+ "2.Modify Email\n"
							+ "3.Modify Department");
					int choice = scan.nextInt();
					if(choice == 1)
					{
						logger.log(Level.INFO,"Enter Mobile Number to update : ");		
						employee.setEmpPhone(scan.next());
						JdbcBeginner.updateRecords(employee.getEmpId(),"mobile",employee.getEmpPhone());

					}
					if(choice == 2)
					{
						logger.log(Level.INFO,"Enter new Email : ");					
						employee.setEmpEmail(scan.next());
						JdbcBeginner.updateRecords(employee.getEmpId(), "email", employee.getEmpEmail());
					}

					if(choice == 3)
					{
						logger.log(Level.INFO,"Enter new Department : ");							
						JdbcBeginner.updateRecords(employee.getEmpId(), "department", employee.getEmpDept());
					}	
					break;
				}
				case 5:
				{
					logger.log(Level.INFO,"Fetching N records from Employee table\n"
							+ "Enter Number of rows to be Fetched : ");
					int nRows = scan.nextInt();
					ArrayList<Object> employees = (ArrayList<Object>) JdbcBeginner.getNRecords("employee","name","asc",nRows);
					printRecord(employees);
					break;
				}
				case 6:
				{
					logger.log(Level.INFO,"Enter Column name to sort");
					String cName = scan.next();
					logger.log(Level.INFO,"Enter asc or desc to sort");
					String sortType = scan.next();
					logger.log(Level.INFO,"Enter Number of records to fetch");
					int nRows = scan.nextInt();
					ArrayList<Object> employees = (ArrayList<Object>) JdbcBeginner.getNRecords("employee",cName,sortType,nRows);
					printRecord(employees);
					break;
				}
				case 7:
				{
					logger.log(Level.INFO,"Enter emp id to delete ");
					int empId = scan.nextInt();
					int affected = JdbcBeginner.deleteRecord(empId);
					logger.log(Level.INFO,affected+" Rows Affected");
					break;
				}
				case 8:
				{
					JdbcBeginner.createDepTable();
					break;
				}
				case 9:
				{
					logger.log(Level.INFO,"Enter num of Records");			
					int count = scan.nextInt();
					for(int i=1;i<=count;i++)
					{
						Dependent dependent = new Dependent();
						logger.log(Level.INFO,"Enter Emp id to add Dependent records");
						
						dependent.setId(scan.nextInt());
						logger.log(Level.INFO,"Enter name of the Dependent");
						
						dependent.setName(scan.next());
						logger.log(Level.INFO,"Enter RelationShip ");
		
						dependent.setRelationShip(scan.next());
						JdbcBeginner.AddRecordsDependent(dependent);
					}
					break;
				}
				case 10:
				{
					logger.log(Level.INFO,"1.emp_id\n"
							+ "2.emp_name");
					int choice = scan.nextInt();
					if(choice ==1)
					{
						logger.log(Level.INFO,"Enter Employee Id ");
						Integer empId = scan.nextInt();					
						ArrayList<Object> dependRecords =(ArrayList<Object>) JdbcBeginner.getRecordsDependent("emp_id",empId,true);
						printRecord(dependRecords);
						
					}
					if(choice ==2)
					{
						logger.log(Level.INFO,"Enter Employee name ");
						String name = scan.next();
						ArrayList<Object> dependRecords =(ArrayList<Object>) JdbcBeginner.getRecordsDependent("name",name,false);
						printRecord(dependRecords);
					}		
					
					break;
				}
				case 11:
				{
					logger.log(Level.INFO,"Enter how many Records to fetch");
					int count = scan.nextInt();
					ArrayList<Object> dependRecords = (ArrayList<Object>) JdbcBeginner.getNRecordSDependent(count);
					printRecord(dependRecords);
					break;
				}
				}

			}
		}
		catch(CustomException e)
		{
			logger.log(Level.SEVERE, e.getMessage());
		}
		scan.close();
	}
}
