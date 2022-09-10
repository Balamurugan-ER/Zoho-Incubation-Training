package com.zoho.bm.runner;

import com.zoho.bm.framework.*;
import java.util.Scanner;
public class TestBstringBuilder {

	private static BstringBuilder obj = new BstringBuilder();
	private static Scanner scan = new Scanner(System.in);

	private void mod1(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder();
		System.out.println(obj.getsbLength(sbString));
		obj.addString(sbString, string);
		System.out.println(obj.getsbLength(sbString));
	}
	private void mod2(String string) throws CustomException
	{
		int n =4;
		StringBuilder sbString = obj.createSBuilder(string);
		System.out.println(obj.getsbLength(sbString));
		for(int i=0;i<n;i++)
		{
			String str = scan.next();
			obj.addString(sbString, "#"+str);
		}
		System.out.println(obj.getsbLength(sbString));
		System.out.println(sbString);
		
	}
	/*
	private void mod3(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		System.out.println(obj.getsbLength(sbString));
//		int index =
		obj.findDelimiter(sbString,' ');
//		System.out.println("Enter String");
//		String strNew = scan.next();
//		obj.addString(sbString, index+1, strNew+" ");
//		System.out.println(sbString);
	}
	*/
	public static void main(String[] args) throws CustomException
	{
		boolean flag = true;
		TestBstringBuilder test = new TestBstringBuilder();
		while(flag)
		{	
			System.out.println("1.Create Empty StringBuilder");
			System.out.println("2.Creates StringBuilder with String");
			System.out.println("0. Exit");
			System.out.println("Enter Your Choice");
			int choice = scan.nextInt();
			try
			{
				switch(choice)
				{
				case 0:
				{
					System.out.println("Thanks & Welcome");
					flag = false;
					break;
				}
				case 1:
				{
					System.out.println("Enter String : ");
					String string = scan.next();
					test.mod1(string);
					break;
				}
				case 2:
				{
					System.out.println("Enter String To Create a StringBuilder :");
					String string = scan.next();
					test.mod2(string);
					break;
				}
				case 3:
				{
					System.out.println("Enter String To Create a StringBuilder");
					scan.nextLine();
					String string = scan.nextLine();
					StringBuilder sbString = new StringBuilder();
					//test.mod3("Bala is a student");
					break;
				}
				case 4:
				{
					
					break;
				}
				}
			}
			catch(CustomException e)
			{
				System.out.println(e);
				//e.printStackTrace();
			}
			/*catch(NumberFormatException e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
			*/
		}

	}

}
