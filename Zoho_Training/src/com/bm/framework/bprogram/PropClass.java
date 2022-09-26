package com.bm.framework.bprogram;
import java.util.*;

import com.bm.util.CustomException;

import java.io.*;
public class PropClass
{
	public static Properties properties = new Properties();
	public static void addEntry(String fileName,String key,String value) throws CustomException
	{
		try
		{
			ProgrammingBasic.createDirectory("/home/inc5/myDir/");
			OutputStream outputStream = new FileOutputStream("/home/inc5/myDir/"+fileName);
			properties.setProperty(key, value);
			properties.store(outputStream, null);
		}
		catch(FileNotFoundException e)
		{
			throw new CustomException("File not found");
		}
		catch(IOException e)
		{
			throw new CustomException("Error while writing file");
		}		
	}
	public static String getPropsValue(String fileName,String key) throws CustomException
	{
		try 
		{
			InputStream inputStream = new FileInputStream("/home/inc5/myDir/"+fileName);
			properties.load(inputStream);
			return properties.getProperty(key);
			
		}
		catch (FileNotFoundException e) 
		{
			
			throw new CustomException("File not found");
		} 
		catch (IOException e) 
		{
			throw new CustomException("Error while reading file");
		}
	}
	public static void printAll()
	{
		properties.list(System.out);
	}

}