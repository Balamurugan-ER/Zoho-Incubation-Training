/**
 * 
 */
package com.bm.framework.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.bm.framework.jdbc.Employee;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.bm.util.CustomException;

/**
 * @author Balamurugan
 *
 */
public class PlayWithJson 
{	
	public JSONObject createJson(String fileName) throws CustomException
	{
		JSONObject json = new JSONObject();
		json.put("name", "Balamurugan");
		json.put("Role", "ZohoCorp");
		json.put("id", 3365);
		JSONArray taskCompleted = new JSONArray();
		taskCompleted.put(0,"CustomHashMap");
		taskCompleted.put(1,"Unit Testing");
		taskCompleted.put(2,"Serialization");
		JSONArray taskIncomplete = new JSONArray();
		taskIncomplete.put(0,"Topics To Explore");
		taskIncomplete.put(1,"JSON");
		taskIncomplete.put(2,"Full Revision");
		json.put("completed tasks", taskCompleted);
		json.put("incomplete tasks", taskIncomplete);
		Employee employee = new Employee();
		employee.setEmpId(0);
		employee.setEmpName("Test");
		employee.setEmpPhone("1234");
		employee.setEmpEmail("test@123.com");
		employee.setEmpDept("test");
		json.putOnce("Employee", employee);
		Employee jsonArray = employee;
		try {
			Files.write(Paths.get(fileName),json.toString().getBytes());
			 return json;
		} catch (IOException e) 
		{
			throw new CustomException("File writing failed");
		}
	}
	public JSONObject parseJsonFile(String fileName) throws CustomException
	{
		try(FileInputStream inputStream = new FileInputStream(new File(fileName));) 
		{
			JSONTokener tokener = new JSONTokener(inputStream);
			JSONObject json = new JSONObject(tokener);
			System.out.println(json.opt("Employeeee"));
			return json;
		} 
		catch (FileNotFoundException e) 
		{
			throw new CustomException(e.getMessage());
		}
		catch (IOException e1) 
		{
			throw new CustomException(e1.getMessage());
		}
	}
}
