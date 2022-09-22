/**
 * 
 */
package com.bm.testrunner;
import java.util.Scanner;
import com.bm.framework.jdbc.*;
/**
 * @author Balamurugan
 *
 */
public class TestJdbc 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		System.out.println("1.Enter to Create Database");
		while(flag)
		{
			System.out.println("Enter your choice");
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
				JdbcBeginner jdbc = new JdbcBeginner();
				jdbc.createTable();
				System.out.println("Created Succesfully1");
				break;
			}
			}
		}
	}
}
