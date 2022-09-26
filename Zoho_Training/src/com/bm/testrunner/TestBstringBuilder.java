package com.bm.testrunner;

import com.bm.framework.stringbuilder.*;
import com.bm.util.*;
import java.util.*;
public class TestBstringBuilder {

	private static BstringBuilder obj = new BstringBuilder();
	private static Scanner scan = new Scanner(System.in);

	private void mod1(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder();
		System.out.println(obj.getsbLength(sbString));
		obj.addString(sbString, string);
		System.out.println(obj.getsbLength(sbString)+"-"+sbString);
	}
	private void mod2(String string) throws CustomException
	{
		int n =4;
		StringBuilder sbString = obj.createSBuilder(null);
		System.out.println(obj.getsbLength(sbString));
		for(int i=0;i<n;i++)
		{
			String str = scan.next();
			obj.addString(sbString, "#"+str);
		}
		System.out.println(obj.getsbLength(sbString));
		System.out.println(sbString);

	}
	private void mod3(String string,String newString) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		System.out.println(obj.getsbLength(sbString));
		int index = obj.findDelimiter(sbString, ' ',true);
		obj.addString(sbString, index+1, newString+" ");
		System.out.println(sbString);
		System.out.println(obj.getsbLength(sbString));

	}
	private void mod4(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		System.out.println(obj.getsbLength(sbString));
		int index = obj.findDelimiter(sbString, ' ',true);
		obj.deleteRange(sbString, 0, index+1);	
		System.out.println(sbString);
		System.out.println(obj.getsbLength(sbString));
	}
	private void mod5(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		sbString = obj.sbConcat(sbString, "-");
		System.out.println(sbString+"-"+obj.getsbLength(sbString));

	}
	private void mod6(String string) throws CustomException
	{	
		StringBuilder sbString = obj.createSBuilder(string);
		System.out.println(obj.getsbLength(sbString));
		sbString = obj.sbReverse(sbString);
		System.out.println(sbString+"-"+obj.getsbLength(sbString));
	}
	private void mod7(String string,int start,int end) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		System.out.println(obj.getsbLength(sbString));
		obj.deleteRange(sbString, start, end);
		System.out.println(sbString+"-"+obj.getsbLength(sbString));

	}
	private void mod8(String string,int start,int end,String subString) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(subString);
		System.out.println(obj.getsbLength(sbString));
		obj.sbReplace(sbString, start, end, subString);
		System.out.println(sbString+"-"+obj.getsbLength(sbString));
	}
	private void mod9(String string,boolean first) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		sbString = obj.sbConcat(sbString, "#");
		System.out.println("Length : "+obj.getsbLength(sbString));
		int index = obj.findDelimiter(sbString, '#', first);
		System.out.println("Index : "+index);		
	}
	public static void main(String[] args) throws CustomException
	{
		boolean flag = true;
		TestBstringBuilder test = new TestBstringBuilder();
		try
		{
			while(flag)
			{	
				System.out.println("1.Create Empty StringBuilder");
				System.out.println("2.Creates StringBuilder with String");
				System.out.println("3.Add String at the Center of the StringBuilder");
				System.out.println("4.Delete First String");
				System.out.println("5.Replaces With Delimiter");
				System.out.println("6.Reverse the StringBuilder");
				System.out.println("7.Deletes with Range");
				System.out.println("8.Replaces with SubString");
				System.out.println("9.Find First/Last IndexOf #");
				System.out.println("0. Exit");
				System.out.println("1000.Sanity Check");
				System.out.println("Enter Your Choice");
				int choice = scan.nextInt();
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
					System.out.println("Enter String To Add in Center :");
					String newString = scan.next();
					test.mod3(string,newString);
					break;
				}
				case 4:
				{
					System.out.println("Enter String To Create a StringBuilder");
					scan.nextLine();
					String string = scan.nextLine();
					test.mod4(string);
					break;
				}
				case 5:
				{
					System.out.println("Enter Three Strings in a Line");
					scan.nextLine();
					String string = scan.nextLine();
					test.mod5(string);	
					break;
				}
				case 6:
				{
					System.out.println("Enter Three Strings in a Line");
					scan.nextLine();
					String string = scan.nextLine();
					test.mod6(string);	
					break;
				}
				case 7:
				{
					System.out.println("Enter the String minimum of 10 chars");
					scan.nextLine();
					String string = scan.nextLine();
					System.out.println("Enter start Range: ");
					int start = scan.nextInt();
					System.out.println("Enter end range: ");
					int end = scan.nextInt();
					test.mod7(string,start,end);
					break;
				}
				case 8:
				{
					System.out.println("Enter the String minimum of 10 chars");
					scan.nextLine();
					String string = scan.nextLine();
					System.out.println("Enter start Range: ");
					int start = scan.nextInt();
					System.out.println("Enter end range: ");
					int end = scan.nextInt();
					System.out.println("Enter the subString: ");
					String subString = scan.next();
					test.mod8(string,start,end,subString);
					break;
				}
				case 9:
				{
					System.out.println("Enter Three Strings in a Line");
					scan.nextLine();
					String string = scan.nextLine();
					System.out.println("Enter true-First/false-Last");
					boolean first = scan.nextBoolean();
					test.mod9(string,first);	
					break;
				}
				case 1000:
				{
					Utilities.VALID.check("com.bm.framework.stringbuilder.BstringBuilder");
					break;
				}
				}
			}
		}
		catch(CustomException e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			System.out.println(e);
			//e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid Input");
			//e.printStackTrace();
		}


	}

}


//TODO: delete the createstirng builder method
