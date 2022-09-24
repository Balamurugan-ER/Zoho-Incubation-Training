package com.bm.testrunner;
import java.util.ArrayList;
import java.util.Scanner;
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
			System.out.println(records.get(i));
		}
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("1.Enter to Create Table");
		System.out.println("2.Enter N records in Employee table");
		System.out.println("3.Get Record for a given employee name");
		System.out.println("4.Updating values in records");
		System.out.println("5.Fetch N records from Emp table");
		System.out.println("6.Fetch N records ordered");
		System.out.println("7.Delete Record");
		System.out.println("8.Create Dependent Table");
		System.out.println("9.Add Entry in Dependent table");
		System.out.println("10.List depenend record for given emp id");
		System.out.println("11.Fetch N records from dependent table");
		try
		{
			while(flag)
			{
				System.out.println("Enter your choice");
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
					System.out.println("Created Succesfully1");
					break;
				}
				case 2:
				{
					System.out.println("Enter no of records you want to add in Employee table");
					int count = scan.nextInt();
					for(int i=1;i<=count;i++)
					{
						Employee employee = new Employee();
						System.out.println("Enter EmpId ");
						employee.setEmpId(scan.nextInt());
						scan.nextLine();
						System.out.println("Enter Emp Name");
						employee.setEmpName(scan.nextLine());
						System.out.println("Enter Emp mobile number");
						employee.setEmpPhone(scan.nextLine());
						System.out.println("Enter Emp mail");
						employee.setEmpEmail(scan.nextLine());
						System.out.println("Enter Emp Dept");
						employee.setEmpDept(scan.nextLine());
						JdbcBeginner.addEntry(employee);
					}
					break;
				}
				case 3:
				{
					System.out.println("Enter name to find a complete record ");
					String name = scan.next();
					ArrayList<Object> employees = (ArrayList<Object>) JdbcBeginner.getRecord(name);
					printRecord(employees);
					break;
				}
				case 4:
				{
					System.out.println("Enter Emp id To update the data");
					Employee employee = new Employee();
					employee.setEmpId(scan.nextInt());
					System.out.println("Enter Choice : ");
					System.out.println("1.Modify Mobile");
					System.out.println("2.Modify Email");
					System.out.println("3.Modify Department");
					int choice = scan.nextInt();
					if(choice == 1)
					{
						System.out.println("Enter Mobile Number to update : ");		
						employee.setEmpPhone(scan.next());
						JdbcBeginner.updateRecords(employee.getEmpId(),"mobile",employee.getEmpPhone());

					}
					if(choice == 2)
					{
						System.out.println("Enter new Email : ");					
						employee.setEmpEmail(scan.next());
						JdbcBeginner.updateRecords(employee.getEmpId(), "email", employee.getEmpEmail());
					}

					if(choice == 3)
					{
						System.out.println("Enter new Department : ");							
						JdbcBeginner.updateRecords(employee.getEmpId(), "department", employee.getEmpDept());
					}	
					break;
				}
				case 5:
				{
					System.out.println("Fetching N records from Employee table");
					System.out.println("Enter Number of rows to be Fetched : ");
					int nRows = scan.nextInt();
					ArrayList<Object> employees = (ArrayList<Object>) JdbcBeginner.getNRecords("employee","name","asc",nRows);
					printRecord(employees);
					break;
				}
				case 6:
				{
					System.out.println("Enter Column name to sort");
					String cName = scan.next();
					System.out.println("Enter asc or desc to sort");
					String sortType = scan.next();
					System.out.println("Enter Number of records to fetch");
					int nRows = scan.nextInt();
					ArrayList<Object> employees = (ArrayList<Object>) JdbcBeginner.getNRecords("employee",cName,sortType,nRows);
					printRecord(employees);
					break;
				}
				case 7:
				{
					System.out.println("Enter emp id to delete ");
					int empId = scan.nextInt();
					int affected = JdbcBeginner.deleteRecord(empId);
					System.out.println(affected+" Rows Affected");
					break;
				}
				case 8:
				{
					JdbcBeginner.createDepTable();
					break;
				}
				case 9:
				{
					System.out.println("Enter num of Records");			
					int count = scan.nextInt();
					for(int i=1;i<=count;i++)
					{
						Dependent dependent = new Dependent();
						System.out.println("Enter Emp id to add Dependent records");
						
						dependent.setId(scan.nextInt());
						System.out.println("Enter name of the Dependent");
						
						dependent.setName(scan.next());
						System.out.println("Enter RelationShip ");
		
						dependent.setRelationShip(scan.next());
						JdbcBeginner.AddRecordsDependent(dependent);
					}
					break;
				}
				case 10:
				{
					System.out.println("1.emp_id");
					System.out.println("2.emp_name");
					int choice = scan.nextInt();
					if(choice ==1)
					{
						System.out.println("Enter Employee Id ");
						Integer empId = scan.nextInt();					
						ArrayList<Object> dependRecords =(ArrayList<Object>) JdbcBeginner.getRecordsDependent("emp_id",empId,true);
						printRecord(dependRecords);
						
					}
					if(choice ==2)
					{
						System.out.println("Enter Employee name ");
						String name = scan.next();
						ArrayList<Object> dependRecords =(ArrayList<Object>) JdbcBeginner.getRecordsDependent("name",name,false);
						printRecord(dependRecords);
					}		
					
					break;
				}
				case 11:
				{
					System.out.println("Enter how many Records to fetch");
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
			e.getMessage();
			e.printStackTrace();
		}
		scan.close();
	}
}
