/**
 * 
 */
package runner;

import mymap.*;
import java.util.*;

/**
 * @author Balamurugan
 *
 */
public class TestRunner<K,V> {
	private BetaMap<K,V> map = new BetaMap<>();
	public void push(K key,V value)
	{
		map.pushEntry(key, value);
	}
	public void getValue(K key)
	{
		System.out.println(map.getValue(key));
	}
	public void printMap()
	{
		map.printMap();
	}
	public static void main(String[] args) {
		TestRunner<String, String> test = new TestRunner<>();
		System.out.println("1.Add key and value to map");
		System.out.println("2.Enter key to find value");
		System.out.println("3.Print Map");
		System.out.println("0.Exit");
		try(Scanner scan = new Scanner(System.in))
		{	
			boolean flag = true;
			while(flag)
			{
				System.out.println("Enter Your choice");
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
					System.out.println("Enter Key and Value");
					String key = scan.next();
					String value = scan.next();
					test.push(key, value);
					break;
				}
				case 2:
				{
					System.out.println("Enter Key and Value");
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
			System.out.println("Invalid input type");
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			System.out.println("String Argument Found Instead of Number");
			e.printStackTrace();
		}
	}

}
