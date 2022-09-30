package com.bm.framework.bprogram;
import java.util.*;

import com.bm.util.CustomException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class MyProps
{
	public static Properties properties = new Properties();
	public static void addEntry(String path,String fileName,String key,String value) throws CustomException
	{
		try
		{
			Path location = Paths.get(path);
			if(!Files.exists(location))
			{
				ProgrammingBasic.createDirectory(path);
			}
			OutputStream outputStream = new FileOutputStream(path+fileName);
			properties.setProperty(key, value);
			System.out.println(properties.get(key));
			properties.store(outputStream, null);
			outputStream.close();
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
	public static String getPropsValue(String path,String fileName,String key) throws CustomException
	{
		try 
		{
			InputStream inputStream = new FileInputStream(path+fileName);
			properties.load(inputStream);
			inputStream.close();
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