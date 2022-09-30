/**
 * 
 */
package com.bm.testrunner;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bm.framework.customhashmap.BetaMap;

/**
 * @author Balamurugan
 *
 */
public class TestCustomHashmap<K,V> {
	private static Logger logger = Logger.getLogger(TestCustomHashmap.class.getName());
	private BetaMap<K,V> map = new BetaMap<>();
	public void push(K key,V value)
	{
		map.pushEntry(key, value);
	}
	public void getValue(K key)
	{
		logger.log(Level.INFO,"{0}",map.getValue(key));
	}
	public void printMap()
	{
		map.printMap();
	}
	public static void main(String[] args) {
		TestCustomHashmap<String, String> test = new TestCustomHashmap<>();
		logger.log(Level.INFO,"1.Add key and value to map\n"
				+ "2.Enter key to find value\n"
				+ "3.Print Map\n"
				+ "0.Exit");
		try(Scanner scan = new Scanner(System.in))
		{	
			boolean flag = true;
			while(flag)
			{
				logger.log(Level.INFO,"Enter Your choice");
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
					logger.log(Level.INFO,"Enter Key and Value");
					String key = scan.next();
					String value = scan.next();
					test.push(key, value);
					break;
				}
				case 2:
				{
					logger.log(Level.INFO,"Enter Key and Value");
					String key = scan.next();
					test.getValue(key);
					break;
				}
				case 3:
				{
					test.printMap();
					break;
				}
				}

			}


		}
		catch(InputMismatchException e)
		{
			logger.log(Level.SEVERE,"Invalid input type");
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.SEVERE,"String Argument Found Instead of Number");
			e.printStackTrace();
		}
	}

}
