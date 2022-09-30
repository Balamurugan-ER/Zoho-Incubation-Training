package com.bm.testrunner;

import com.bm.framework.stringbuilder.*;
import com.bm.util.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class TestBstringBuilder {

	private static BstringBuilder obj = new BstringBuilder();
	private static Scanner scan = new Scanner(System.in);
	private static Logger logger = Logger.getLogger(TestBstringBuilder.class.getName());
	private void mod1(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder();
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		obj.addString(sbString, string);
		logger.log(Level.INFO,obj.getsbLength(sbString)+"-"+sbString);
	}
	private void mod2(String string) throws CustomException
	{
		int n =4;
		StringBuilder sbString = obj.createSBuilder(null);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		for(int i=0;i<n;i++)
		{
			String str = scan.next();
			obj.addString(sbString, "#"+str);
		}
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		logger.log(Level.INFO,"{0}",sbString);

	}
	private void mod3(String string,String newString) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		int index = obj.findDelimiter(sbString, ' ',true);
		obj.addString(sbString, index+1, newString+" ");
		logger.log(Level.INFO,"{0}",sbString);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));

	}
	private void mod4(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		int index = obj.findDelimiter(sbString, ' ',true);
		obj.deleteRange(sbString, 0, index+1);	
		logger.log(Level.INFO,"{0}",sbString);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
	}
	private void mod5(String string) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		sbString = obj.sbConcat(sbString, "-");
		logger.log(Level.INFO,sbString+"-"+obj.getsbLength(sbString));

	}
	private void mod6(String string) throws CustomException
	{	
		StringBuilder sbString = obj.createSBuilder(string);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		sbString = obj.sbReverse(sbString);
		logger.log(Level.INFO,sbString+"-"+obj.getsbLength(sbString));
	}
	private void mod7(String string,int start,int end) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		obj.deleteRange(sbString, start, end);
		logger.log(Level.INFO,sbString+"-"+obj.getsbLength(sbString));

	}
	private void mod8(String string,int start,int end,String subString) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(subString);
		logger.log(Level.INFO,"{0}",obj.getsbLength(sbString));
		obj.sbReplace(sbString, start, end, subString);
		logger.log(Level.INFO,sbString+"-"+obj.getsbLength(sbString));
	}
	private void mod9(String string,boolean first) throws CustomException
	{
		StringBuilder sbString = obj.createSBuilder(string);
		sbString = obj.sbConcat(sbString, "#");
		logger.log(Level.INFO,"Length : "+obj.getsbLength(sbString));
		int index = obj.findDelimiter(sbString, '#', first);
		logger.log(Level.INFO,"Index : "+index);		
	}
	public static void main(String[] args) throws CustomException
	{
		boolean flag = true;
		TestBstringBuilder test = new TestBstringBuilder();
		try
		{
			while(flag)
			{	
				logger.log(Level.INFO,"1.Create Empty StringBuilder\n"
						+ "2.Creates StringBuilder with String\n"
						+ "3.Add String at the Center of the StringBuilder\n"
						+ "4.Delete First String\n"
						+ "5.Replaces With Delimiter\n"
						+ "6.Reverse the StringBuilder\n"
						+ "7.Deletes with Range\n"
						+ "8.Replaces with SubString\n"
						+ "9.Find First/Last IndexOf #\n"
						+ "0. Exit\n"
						+ "1000.Sanity Check\n"
						+ "Enter Your Choice");
				int choice = scan.nextInt();
				switch(choice)
				{
				case 0:
				{
					logger.log(Level.INFO,"Thanks & Welcome");
					flag = false;
					break;
				}
				case 1:
				{
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					test.mod1(string);
					break;
				}
				case 2:
				{
					logger.log(Level.INFO,"Enter String To Create a StringBuilder :");
					String string = scan.next();
					test.mod2(string);
					break;
				}
				case 3:
				{
					logger.log(Level.INFO,"Enter String To Create a StringBuilder");
					scan.nextLine();
					String string = scan.nextLine();
					logger.log(Level.INFO,"Enter String To Add in Center :");
					String newString = scan.next();
					test.mod3(string,newString);
					break;
				}
				case 4:
				{
					logger.log(Level.INFO,"Enter String To Create a StringBuilder");
					scan.nextLine();
					String string = scan.nextLine();
					test.mod4(string);
					break;
				}
				case 5:
				{
					logger.log(Level.INFO,"Enter Three Strings in a Line");
					scan.nextLine();
					String string = scan.nextLine();
					test.mod5(string);	
					break;
				}
				case 6:
				{
					logger.log(Level.INFO,"Enter Three Strings in a Line");
					scan.nextLine();
					String string = scan.nextLine();
					test.mod6(string);	
					break;
				}
				case 7:
				{
					logger.log(Level.INFO,"Enter the String minimum of 10 chars");
					scan.nextLine();
					String string = scan.nextLine();
					logger.log(Level.INFO,"Enter start Range: ");
					int start = scan.nextInt();
					logger.log(Level.INFO,"Enter end range: ");
					int end = scan.nextInt();
					test.mod7(string,start,end);
					break;
				}
				case 8:
				{
					logger.log(Level.INFO,"Enter the String minimum of 10 chars");
					scan.nextLine();
					String string = scan.nextLine();
					logger.log(Level.INFO,"Enter start Range: ");
					int start = scan.nextInt();
					logger.log(Level.INFO,"Enter end range: ");
					int end = scan.nextInt();
					logger.log(Level.INFO,"Enter the subString: ");
					String subString = scan.next();
					test.mod8(string,start,end,subString);
					break;
				}
				case 9:
				{
					logger.log(Level.INFO,"Enter Three Strings in a Line");
					scan.nextLine();
					String string = scan.nextLine();
					logger.log(Level.INFO,"Enter true-First/false-Last");
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
			logger.log(Level.SEVERE,"EXCEPTION {0}",e);
			//e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.SEVERE,"EXCEPTION {0}",e);
			//e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			logger.log(Level.SEVERE,"EXCEPTION {0}",e);
			//e.printStackTrace();
		}


	}

}


//TODO: delete the createstirng builder method
