/**
 * 
 */
package com.bm.framework.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author inc5
 *
 */
import com.bm.framework.jdbc.Employee;
public class TrySerialization 
{
	private Logger logger = Logger.getLogger(TrySerialization.class.getName());
	private ArrayList<Employee> employees = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	public void addDummyValues()
	{		
		int n = 10;
		for(int i=0;i<n;i++)
		{
			Employee employee = new Employee();
			employee.setEmpId(1);
			employee.setEmpName("Bala");
			employee.setEmpPhone("123456789");
			employee.setEmpEmail("bala@zohocorp.com");
			employee.setEmpDept("Dev");
			employees.add(employee);
		}
	}
	public void displayValue()
	{
		logger.log(Level.INFO, "Enter Number");
		int n= scan.nextInt();
		
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"{0}",employees.get(i));
		}
	}
	public void serializeObject()
	{
		String name = scan.next();
		try (FileOutputStream fileStream = new FileOutputStream(name);
				ObjectOutputStream os = new ObjectOutputStream(fileStream);)
		{
			os.writeObject(employees);
			logger.log(Level.INFO,"Serialization completed");
		}
		catch (FileNotFoundException e) 
		{
			logger.log(Level.SEVERE,e.getMessage());
		} catch (IOException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
	}
	public void deSerializeObject()
	{
		logger.log(Level.INFO, "Enter File Name to Deserialize");
		String name = scan.next();
		try(FileInputStream fileStream = new FileInputStream(name);
				ObjectInputStream os = new ObjectInputStream(fileStream);)
		{
			Object obj = os.readObject();
			ArrayList<Employee> empList = (ArrayList<Employee>) obj;
			logger.log(Level.INFO,"Object deserialized Successfully");
			displayValue();
		} 
		catch (FileNotFoundException e) 
		{
			logger.log(Level.SEVERE,e.getMessage());
		} 
		catch (IOException e) {
			logger.log(Level.SEVERE,e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.log(Level.SEVERE,e.getMessage());
		}
	}
}
