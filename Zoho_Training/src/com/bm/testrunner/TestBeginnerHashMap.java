/**
 * 
 */
package com.bm.testrunner;
import com.bm.framework.hashmap.BeginnerHashMap;
import com.bm.framework.hashmap.Remote;
import com.bm.util.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Balamurugan
 */
public class TestBeginnerHashMap {
	BeginnerHashMap begin = new BeginnerHashMap();
	HashMap<String,String> defaultHmap = new HashMap<String,String>();
	private static Scanner scan = new Scanner(System.in);
	private static Logger logger = Logger.getLogger(TestBeginnerHashMap.class.getName());
	private void printMap(Map map) throws CustomException
	{
		logger.log(Level.INFO,"{0}",map);
		logger.log(Level.INFO,"{0}",begin.getMapSize(map));
	}

	private HashMap getDefaultHmap() throws CustomException
	{
		begin.addEntry(defaultHmap,"Tamil", "A");
		begin.addEntry(defaultHmap,"English", "B");
		begin.addEntry(defaultHmap,null, "O");
		return defaultHmap;
	}
	private void mod1() throws CustomException
	{
		HashMap map = new HashMap();
		printMap(map);
	}
	private void mod2() throws CustomException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		int n= scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter String Key & Value: ");
			String key = scan.next();
			String value = scan.next();
			begin.addEntry(map, key, value);
		}
		printMap(map);
	}
	private void mod3() throws CustomException
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter Integer Key & Integer Value: ");
			int key = scan.nextInt();
			int value = scan.nextInt();
			begin.addEntry(map, key, value);
		}
		printMap(map);
	}
	private void mod4() throws CustomException
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter String Key & Integer Value: ");
			String key = scan.next();
			int value = scan.nextInt();
			begin.addEntry(map, key, value);
		}
		printMap(map);
	}
	private void mod5() throws CustomException
	{
		HashMap<String,Remote> map = new HashMap<String,Remote>();
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter String Key : ");
			String key = scan.next();
			logger.log(Level.INFO,"Enter Number of Buttons Value : ");
			String value = scan.next();
			begin.addEntry(map, key, new Remote(value));
		}
		printMap(map);
	}
	private void mod6() throws CustomException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter String Key   : ");
			String key = scan.next();
			logger.log(Level.INFO,"Enter String Value : ");
			String value = scan.next();
			begin.addEntry(map, key, value);
		}
		begin.addEntry(map, "Hello", null);
		printMap(map);
	}
	private void mod7() throws CustomException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter String Key   : ");
			String key = scan.next();
			logger.log(Level.INFO,"Enter String Value : ");
			String value = scan.next();
			begin.addEntry(map, key, value);
		}
		begin.addEntry(map,null,"Hello");
		printMap(map);
	}
	private void mod8() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		logger.log(Level.INFO,"Enter true/false to value/key search : ");
		boolean value = scan.nextBoolean();
		logger.log(Level.INFO,"Enter key/value to find");
		String Search = scan.next();
		logger.log(Level.INFO,"{0}",begin.checkKey(defaultHmap, Search, value));
	}
	private void mod9() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		int n=scan.nextInt();
		for(int i=0;i<n;i++)
		{
			logger.log(Level.INFO,"Enter value for key and updated Value: ");
			String key = scan.next();
			String value = scan.next();
			begin.addEntry(defaultHmap,key,value);
		}
		printMap(defaultHmap);
	}
	private void mod10() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		logger.log(Level.INFO,"Enter key to get value associated with it.");
		String key = scan.next();
		logger.log(Level.INFO,"Enter Default value if key not found");
		String dValue = scan.next();
		logger.log(Level.INFO,"{0}",begin.getValue(defaultHmap, key,dValue));
	}
	private void mod11() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		logger.log(Level.INFO,"Enter key to remove.");
		String key = scan.next();
		logger.log(Level.INFO,"{0}",begin.removeKey(defaultHmap, key));
		printMap(defaultHmap);
	}
	private void mod12() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		logger.log(Level.INFO,"Enter key to remove");
		String key = scan.next();
		logger.log(Level.INFO,"Enter Value to remove");
		String value = scan.next();
		logger.log(Level.INFO,"{0}",begin.removeEntry(defaultHmap, key,value));
		printMap(defaultHmap);
	}
	private void mod13() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		logger.log(Level.INFO,"Enter key to replace");
		String key = scan.next();
		logger.log(Level.INFO,"Enter Value to replace");
		String value = scan.next();
		begin.replaceValues(defaultHmap, key, value);
		printMap(defaultHmap);
	}
	private void mod14() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		logger.log(Level.INFO,"Enter key to replace");
		String key = scan.next();
		logger.log(Level.INFO,"Enter new Value to replace");
		String newValue = scan.next();
		logger.log(Level.INFO,"Enter Old Value to replace");
		String oldValue = scan.next();
		begin.replaceValues(defaultHmap, key, newValue,oldValue);
		printMap(defaultHmap);
	}
	private void mod15() throws CustomException
	{
		getDefaultHmap();
		for(String i : defaultHmap.keySet())
		{
			logger.log(Level.INFO,"-"+begin.getValue(defaultHmap, i));
		}
	}
	private void mod16() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		begin.removeAll(defaultHmap);
		printMap(defaultHmap);
	}
	public static void main(String[] args) throws CustomException
	{
		TestBeginnerHashMap test = new TestBeginnerHashMap();
		
			boolean flag = true;
			logger.log(Level.INFO,"1.To Create HashMap and Print Size\n"
					+ "2.Add String Key and String Value\n"
					+ "3.Add Integer Key and Integer Value\n"
					+ "4.Add String Key and Integer Value\n"
					+ "5.Create String Key and Remote Object Value\n"
					+ "6.Enter Two Entries with one Null value\n"
					+ "7.Enter Two Entries with one Null Key\n"
					+ "8.Search Map Elements by key/value\n"
					+ "9.Update all the values\n"
					+ "10.Get Values using keys\n"
					+ "11.Enter Key to remove\n"
					+ "12.Enter key and value to remove\n"
					+ "13.Replace key with value\n"
					+ "14.Replace key with value only matches old value\n"
					+ "15.Printing the Hashmap\n"
					+ "16.Remove all Entries\n"
					+ "0.Exit\n"
					+ "1000.Sanity Check\n"
					+ "Enter Your choice : ");
			try 
			{
			while(flag)
			{
				int n = scan.nextInt();
				if(n!=1000 && n<0 || n>16)
				{
					logger.log(Level.INFO,"Invalid Option");
					flag=false;
					break;
				}
				switch(n)
				{
				case 0:
				{
					flag = false;
					break;
				}
				case 1:
				{
					test.mod1();
					break;
				}
				case 2:
				{
					test.mod2();
					break;
				}
				case 3:
				{
					test.mod3();
					break;
				}
				case 4:
				{
					test.mod4();
					break;
				}
				case 5:
				{
					test.mod5();
					break;
				}
				case 6:
				{
					test.mod6();
					break;
				}
				case 7:
				{
					test.mod7();
					break;
				}
				case 8:
				{
					test.mod8();
					break;
				}
				case 9:
				{
					test.mod9();
					break;
				}
				case 10:
				{
					test.mod10();
					break;
				}
				case 11:
				{
					test.mod11();
					break;
				}
				case 12:
				{
					test.mod12();
					break;
				}
				case 13:
				{
					test.mod13();
					break;
				}
				case 14:
				{
					test.mod14();
					break;
				}
				case 15:
				{
					test.mod15();
					break;
				}
				case 16:
				{
					test.mod16();
					break;
				}
				case 1000:
				{
					Utilities.INST.check("com.bm.framework.hashmap.BeginnerHashMap");
					break;
				}
				}
			}
		}
		catch(CustomException e)
		{
			logger.log(Level.SEVERE,"{0}",e);
			e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			logger.log(Level.SEVERE,"Invalid Input");
			e.printStackTrace();
		}
		finally
		{
			scan.close();
		}
	}

}
