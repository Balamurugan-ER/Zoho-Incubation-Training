/**
 * 
 */
package com.bm.testrunner;
import com.bm.framework.hashmap.BeginnerHashMap;
import com.bm.framework.hashmap.Remote;
import com.bm.util.*;
import java.util.*;
/**
 * @author Balamurugan
 */
public class TestBeginnerHashMap {
	BeginnerHashMap begin = new BeginnerHashMap();
	HashMap<String,String> defaultHmap = new HashMap<String,String>();
	private static Scanner scan = new Scanner(System.in);
	private void printMap(Map map) throws CustomException
	{
		System.out.println(map);
		System.out.println(begin.getMapSize(map));
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
		int n=3;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter String Key   : ");
			String key = scan.next();
			System.out.println("Enter String Value : ");
			String value = scan.next();
			begin.addEntry(map, key, value);
		}
		printMap(map);
	}
	private void mod3() throws CustomException
	{
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int n=3;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Integer Key 	: ");
			int key = scan.nextInt();
			System.out.println("Enter Integer Value : ");
			int value = scan.nextInt();
			begin.addEntry(map, key, value);
		}
		printMap(map);
	}
	private void mod4() throws CustomException
	{
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int n=3;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter String Key 	: ");
			String key = scan.next();
			System.out.println("Enter Integer Value : ");
			int value = scan.nextInt();
			begin.addEntry(map, key, value);
		}
		printMap(map);
	}
	private void mod5() throws CustomException
	{
		HashMap<String,Remote> map = new HashMap<String,Remote>();
		int n=3;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter String Key 	: ");
			String key = scan.next();
			System.out.println("Enter Number of Buttons Value : ");
			String value = scan.next();
			begin.addEntry(map, key, new Remote(value));
		}
		printMap(map);
	}
	private void mod6() throws CustomException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		int n=2;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter String Key   : ");
			String key = scan.next();
			System.out.println("Enter String Value : ");
			String value = scan.next();
			begin.addEntry(map, key, value);
		}
		begin.addEntry(map, "Hello", null);
		printMap(map);
	}
	private void mod7() throws CustomException
	{
		HashMap<String,String> map = new HashMap<String,String>();
		int n=2;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter String Key   : ");
			String key = scan.next();
			System.out.println("Enter String Value : ");
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
		System.out.println("Enter true/false to value/key search : ");
		boolean value = scan.nextBoolean();
		System.out.println("Enter key/value to find");
		String Search = scan.next();
		System.out.println(begin.checkKey(defaultHmap, Search, value));
	}
	private void mod9() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		int n=3;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter value for key and updated Value: ");
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
		System.out.println("Enter key to get value associated with it.");
		String key = scan.next();
		System.out.println("Enter Default value if key not found");
		String dValue = scan.next();
		System.out.println(begin.getValue(defaultHmap, key,dValue));
	}
	private void mod11() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		System.out.println("Enter key to remove.");
		String key = scan.next();
		System.out.println(begin.removeKey(defaultHmap, key));
		printMap(defaultHmap);
	}
	private void mod12() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		System.out.println("Enter key to remove");
		String key = scan.next();
		System.out.println("Enter Value to remove");
		String value = scan.next();
		System.out.println(begin.removeEntry(defaultHmap, key,value));
		printMap(defaultHmap);
	}
	private void mod13() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		System.out.println("Enter key to replace");
		String key = scan.next();
		System.out.println("Enter Value to replace");
		String value = scan.next();
		begin.replaceValues(defaultHmap, key, value);
		printMap(defaultHmap);
	}
	private void mod14() throws CustomException
	{
		getDefaultHmap();
		printMap(defaultHmap);
		System.out.println("Enter key to replace");
		String key = scan.next();
		System.out.println("Enter new Value to replace");
		String newValue = scan.next();
		System.out.println("Enter Old Value to replace");
		String oldValue = scan.next();
		begin.replaceValues(defaultHmap, key, newValue,oldValue);
		printMap(defaultHmap);
	}
	private void mod15() throws CustomException
	{
		getDefaultHmap();
		for(String i : defaultHmap.keySet())
		{
			System.out.println(i+"-"+begin.getValue(defaultHmap, i));
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
			System.out.println("1.To Create HashMap and Print Size");
			System.out.println("2.Add String Key and String Value");
			System.out.println("3.Add Integer Key and Integer Value");
			System.out.println("4.Add String Key and Integer Value");
			System.out.println("5.Create String Key and Remote Object Value");
			System.out.println("6.Enter Two Entries with one Null value");
			System.out.println("7.Enter Two Entries with one Null Key");
			System.out.println("8.Search Map Elements by key/value");
			System.out.println("9.Update all the values");
			System.out.println("10.Get Values using keys");
			System.out.println("11.Enter Key to remove");
			System.out.println("12.Enter key and value to remove");
			System.out.println("13.Replace key with value");
			System.out.println("14.Replace key with value only matches old value");
			System.out.println("15.Printing the Hashmap");
			System.out.println("16.Remove all Entries");
			System.out.println("0.Exit");
			try 
			{
			while(flag)
			{
				System.out.println("Enter Your choice : ");
				int n = scan.nextInt();
				if(n<0 || n>16)
				{
					System.out.println("Invalid Option");
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
				}
			}
		}
		catch(CustomException e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid Input");
			e.printStackTrace();
		}
	}

}
