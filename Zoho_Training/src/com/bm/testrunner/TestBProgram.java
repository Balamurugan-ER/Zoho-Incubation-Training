package com.bm.testrunner;
import com.bm.framework.bprogram.*;
import com.bm.util.CustomException;
import com.bm.util.Utilities;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public class TestBProgram 
{
	
	
	public static void main(String[] args) throws Exception 
	{
		Logger logger = Logger.getLogger(TestBProgram.class.getName());
		//ConsoleHandler handler = new ConsoleHandler();
		//handler.setFormatter(new SimpleFormatter());
		//logger.addHandler(handler);
		//logger.setLevel(Level.FINE);
		Scanner scan = new Scanner(System.in);		
		boolean flag = true;
		while(flag)
		{
			logger.log(Level.INFO, "Enter Your choice\n"
					+ "1.Writing content in files\n"
					+ "2.Storing properties\n"
					+ "3.Finding properties value for the key\n"
					+ "4.Calling custom constructor and print object\n"
					+ "5.POJO class calling custom constructor\n"
					+ "6.POJO class calling default constructor & getter , setter methods\n"
					+ "7.Reflection - Invoking POJO class default constructor and custom constructor\n"
					+ "8.Enum with values\n"
					+ "9.Singleton class\n"
					+ "10.Get Current Date Time\n"
					+ "1000.Sanity Check\n"
					+ "0.Exit");
			int choice = -1;
			try
			{
				choice = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException e)
			{
				logger.log(Level.SEVERE, "EXCEPTION {0}",e.getMessage());
			}
			switch (choice)
			{
			case 0:
			{
				flag= false;
				break;
			}
			case 1:
			{
				logger.log(Level.INFO,"Enter path to Directory ex(/home/inc5/myDir/)");
				String path = scan.nextLine();
				logger.log(Level.INFO, "Enter filename to write");
				String fileName = scan.nextLine();
				logger.log(Level.INFO, "Enter Number of Lines to add");
				int limit = scan.nextInt();
				scan.nextLine();
				String value = "";
				logger.log(Level.INFO, "Enter n Strings");
				for(int i=0;i<limit;i++)
				{
					value += scan.nextLine() + "\n";
				}
				try 
				{
					ProgrammingBasic.writeFile(fileName,path,value);
					
				} catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				}
				break;
			}
			case 2:
			{	//create properties with n properties
				logger.log(Level.INFO,"Enter properties name .txt or .properties");
				String fileName = scan.nextLine();
				logger.log(Level.INFO,"Enter path to Store properties ex(/home/inc5/myDir/)");
				String path = scan.nextLine();
				logger.log(Level.INFO,"Enter No of Entries");
				int limit = Integer.parseInt(scan.nextLine());
				scan.nextLine();
				logger.log(Level.INFO,"Provide pair of keys and values");
				for(int i=1;i<=limit;i++)
				{					
					logger.log(Level.INFO,"Enter Key :- {0}",i);
					String key = scan.nextLine();
					logger.log(Level.INFO,"Enter Value :- {0}",i);
					String value = scan.nextLine();
					try
					{
						MyProps.addEntry(path,fileName, key, value);
					} 
					catch (CustomException e) 
					{
						logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
					}
				}
				break;
			}
			case 3:
			{
				//get properties using propname,key 
				logger.log(Level.INFO,"Enter path to load properties ex(/home/inc5/myDir/)");
				String path = scan.nextLine();
				logger.log(Level.INFO,"Enter properties file name to search props :- ");
				String fileName = scan.nextLine();
				System.out.println(fileName);
				logger.log(Level.INFO,"Enter properties key to find? :- ");
				String key = scan.nextLine();
				System.out.println(key);
				String value = MyProps.getPropsValue(path,fileName, key);
				logger.log(Level.INFO,key +" - " +value);
				break;
			}
			case 4:
			{	//to override tostring()
				logger.log(Level.INFO,"Enter String to invoke custom constructor :- ");
				String jasmineVariable = scan.nextLine();
				Jasmine jasmine = new Jasmine(jasmineVariable);
				logger.log(Level.INFO,"Printing Jasmine Object {0}",jasmine);
				break;
			}
			case 5:
			{
				//pojo with toString() --> using custom constructor
				logger.log(Level.INFO, "Enter Fruit Name & Fruit Count");
				String fruitName = scan.nextLine();
				int fruitCount = Integer.parseInt(scan.nextLine());
				Fruits fruit = new Fruits(fruitName,fruitCount);
				logger.log(Level.INFO,"Printing Fruits Object {0}",fruit);
				break;
			}
			case 6:
			{
				//pojo --> using default constructor
				Fruits fruit = new Fruits();
				logger.log(Level.INFO, "Enter Fruit Name & Fruit Count");
				String fruitName = scan.nextLine();
				int fruitCount = Integer.parseInt(scan.nextLine());
				fruit.setFruitName(fruitName);
				fruit.setNoOfFruits(fruitCount);
				logger.log(Level.INFO,"Fruits default Constructor Object {0}",fruit);
				break;
			}
			case 7:
			{
				// reflection a constructor
				// reflection a custom constructor
				try
				{
					Class refClass = Class.forName("programming.Fruits");
					Fruits t = (Fruits) refClass.newInstance();
					Constructor<?> construct = refClass.getDeclaredConstructor(String.class,Integer.class);
					logger.log(Level.INFO,"Enter fruit name :- ");
					String fName = scan.nextLine();
					logger.log(Level.INFO,"Enter fruit Count name :- ");
					int fCount = Integer.parseInt(scan.nextLine());
					Object obj = (Fruits)construct.newInstance(fName,fCount);
					logger.log(Level.INFO,"Printing custom constructor object {0}",obj);
					t.setFruitName(fName);
					t.setNoOfFruits(fCount);
					logger.log(Level.INFO,"Printing default constructor object {0}",t);
				}
				catch (ClassNotFoundException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				}
				catch (InstantiationException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				}
				catch (IllegalAccessException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				}
				catch (IllegalArgumentException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				}
				catch (InvocationTargetException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				}
				catch (NoSuchMethodException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				} 
				catch (SecurityException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {0}", e.getMessage());
				} 
				break;
			}
			case 8:
			{
				// enum colors and color codes
				BasicColors.Color[] color = BasicColors.Color.values();
				for(int i=0;i<color.length;i++)
				{
					BasicColors.Color currentColor = BasicColors.Color.getElement(i);
					int cvalue = BasicColors.Color.getColorCode(currentColor);
					logger.log(Level.INFO,currentColor+"-"+cvalue);
				}
				break;
			}
			case 9:
			{
				// Even we call multiple time singleton won't create new object.
				//Enum Singleton - Seriableable,Thread-safe,Reflection
				CarSingleton carObj1 = CarSingleton.INSTANCE;
				CarSingleton carObj2 = CarSingleton.INSTANCE;
				logger.log(Level.INFO,carObj1.getPatternName());
				logger.log(Level.INFO,carObj2.getPatternName());
				logger.log(Level.INFO,"{0}",carObj1 == carObj2);
				break;
			}
			case 10:
			{
				logger.log(Level.INFO,"Get Current Time");
				String time = ProgrammingBasic.getTime();
				logger.log(Level.INFO,time);
				break;
			}
			case 11:
			{
				logger.log(Level.INFO,"Get Current Time in MilliSeconds");
				long timeMilli = ProgrammingBasic.getTimeMilliSeconds();
				logger.log(Level.INFO,"Time {0}",timeMilli);
				break;
			}
			case 12:
			{
				logger.log(Level.INFO,"Enter Zone to get DateTime ");
				for(String zones : ZoneId.getAvailableZoneIds())
				{
					logger.log(Level.INFO,"{0}",zones);
				}
				String zone = scan.nextLine();
				DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd-mm-yyyy HH:mm:ss");
				ZonedDateTime dateTime = ProgrammingBasic.getDateTime(ZoneId.of(zone));
				logger.log(Level.INFO,"{0}",dft.format(dateTime));
				break;
			}
			case 13:
			{
				logger.log(Level.INFO,"Get Current year Enter Zone Name");
				String zone = scan.nextLine();
				int dateTime = ProgrammingBasic.getYear(ZoneId.of(zone));
				logger.log(Level.INFO,"{0}",dateTime);
				break;
			}
			case 14:
			{
				logger.log(Level.INFO,"Get Current Week Enter Zone Name");
				String zone = scan.nextLine();
				DayOfWeek dateTime = ProgrammingBasic.getWeek(ZoneId.of(zone));
				logger.log(Level.INFO,"Current week is {0}",dateTime);
				break;
			}
			case 15:
			{
				logger.log(Level.INFO,"Get Current Month Enter Zone Name");
				String zone = scan.nextLine();
				int dateTime = ProgrammingBasic.getMonth(ZoneId.of(zone));
				logger.log(Level.INFO,"Month {0}",dateTime);
				break;
			}
			case 1000:
			{
				logger.log(Level.WARNING,"Sanity checking in progress .....");
				Utilities.INST.check("com.bm.framework.bprogram.ProgrammingBasic");
				break;
			}
			}
		}
		scan.close();
		logger.exiting(TestBProgram.class.getName().toString(), "Main Method");
	}

}
