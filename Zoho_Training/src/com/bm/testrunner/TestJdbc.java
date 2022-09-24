/**
 * 
 */
package com.bm.testrunner;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import com.bm.framework.jdbc.*;
import com.bm.util.CustomException;
/**
 * @author Balamurugan
 *
 */
public class TestJdbc 
{
	private static void printRecord(LinkedHashMap<Integer, ArrayList<String>> map)
	{
		for(Entry<Integer, ArrayList<String>> entry : map.entrySet())
		{
			System.out.println(entry.getValue());
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
						System.out.println("Enter EmpId ");
						int empId = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter Emp Name");
						String empName = scan.nextLine();
						System.out.println("Enter Emp mobile number");
						String empMobile = scan.nextLine();
						System.out.println("Enter Emp mail");
						String empEmail = scan.nextLine();
						System.out.println("Enter Emp Dept");
						String empDepartment = scan.nextLine();
						JdbcBeginner.addEntry(empId,empName,empMobile,empEmail,empDepartment);
					}
					break;
				}
				case 3:
				{
					System.out.println("Enter name to find a complete record ");
					String name = scan.next();
					LinkedHashMap<Integer,ArrayList<String>> map  = (LinkedHashMap<Integer, ArrayList<String>>) JdbcBeginner.getRecord(name);
					printRecord(map);
					break;
				}
				case 4:
				{
					System.out.println("Enter Emp id To update the data");
					int empId = scan.nextInt();
					System.out.println("Enter Choice : ");
					System.out.println("1.Modify Mobile");
					System.out.println("2.Modify Email");
					System.out.println("3.Modify Department");
					int choice = scan.nextInt();
					if(choice == 1)
					{
						System.out.println("Enter Mobile Number to update : ");
						String empNum = scan.next();
						JdbcBeginner.updateRecords(empId,"mobile",empNum);
					}
					if(choice == 2)
					{
						System.out.println("Enter new Email : ");
						String empEmail = scan.next();
						JdbcBeginner.updateRecords(empId, "email", empEmail);
					}
					
					if(choice == 3)
					{
						System.out.println("Enter new Department : ");
						String empDept = scan.next();
						JdbcBeginner.updateRecords(empId, "department", empDept);
					}					
				}
				case 5:
				{
					System.out.println("Fetching N records from Employee table");
					System.out.println("Enter Number of rows to be Fetched : ");
					int nRows = scan.nextInt();
					LinkedHashMap<Integer,ArrayList<String>> map = (LinkedHashMap<Integer, ArrayList<String>>) JdbcBeginner.getNRecords(nRows);
					printRecord(map);
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
