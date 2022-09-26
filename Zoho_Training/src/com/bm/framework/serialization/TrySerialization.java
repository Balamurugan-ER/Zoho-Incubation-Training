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

/**
 * @author inc5
 *
 */
import com.bm.framework.jdbc.Employee;
public class TrySerialization 
{
	private ArrayList<Employee> employees = new ArrayList<>();
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
		int n=10;
		for(int i=0;i<n;i++)
		{
			System.out.println(employees.get(i));
		}
	}
	public void serializeObject()
	{
		try (FileOutputStream fileStream = new FileOutputStream("arrayList.ser");
				ObjectOutputStream os = new ObjectOutputStream(fileStream);)
		{
			os.writeObject(employees);
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deSerializeObject()
	{
		try(FileInputStream fileStream = new FileInputStream("arrayList.ser");
				ObjectInputStream os = new ObjectInputStream(fileStream);)
		{
			Object obj = os.readObject();
			ArrayList<Employee> empList = (ArrayList<Employee>) obj;
			displayValue();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
