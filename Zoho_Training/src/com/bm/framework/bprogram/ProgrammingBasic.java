/**
 * 
 */
package com.bm.framework.bprogram;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.bm.util.CustomException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * @author Balamurugan
 */
public class ProgrammingBasic {
	private static  Scanner scan = new Scanner(System.in);
	public static void createDirectory(String path) throws CustomException
	{
		Path location = Paths.get(path);
		if(!Files.exists(location))
		{
			try 
			{
				Files.createDirectory(location);
			} 
			catch (IOException e) 
			{
				throw new CustomException(e.getMessage());
			}
		}
		else
		{
			throw new CustomException("Directory Already Exists");
		}
	}
	public static void writeFile(String fileName,String path) throws  Exception
	{
		createDirectory(path);
		try(FileOutputStream fos = new FileOutputStream(new File("/home/inc5/myDir/"+fileName));
				BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(fos));)
		{
			int n = 3;
			for(int i=0;i<3;i++)
			{
				String line = scan.nextLine();
				bWriter.write(line);
				bWriter.newLine();
			}
		}
		catch(IOException e)
		{
			throw new CustomException("File not found");
			
		}
		catch(Exception e)
		{
			throw new CustomException(e.getMessage());
		}
	}	
	public static String getTime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.now();
		return dtf.format(dateTime);
	}
	public static long getTimeMilliSeconds()
	{
		Date date = new Date();
		long milli = date.getTime();
		return System.currentTimeMillis();
	}
	public static ZonedDateTime getDateTime(ZoneId zone)
	{
		return ZonedDateTime.now(zone);
	}
	public static int getMonth(ZoneId zone)
	{
		int month = getDateTime(zone).getDayOfMonth();
		return month;
	}
	public static DayOfWeek getWeek(ZoneId zone)
	{
		return getDateTime(zone).getDayOfWeek();
	}
	public static int getYear(ZoneId zone)
	{
		return getDateTime(zone).getDayOfYear();
	}
}
