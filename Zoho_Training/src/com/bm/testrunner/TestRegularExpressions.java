/**
 * 
 */
package com.bm.testrunner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bm.framework.regex.RegularExpressions;
import com.bm.util.CustomException;

/**
 * @author Balamurugan
 *
 */
public class TestRegularExpressions 
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		Logger logger = Logger.getLogger(TestRegularExpressions.class.getName());
		boolean flag = true;
		logger.log(Level.INFO, "1.To Valid a Mobile number\n"
				+ "2.To validate Alpha Numeric String\n"
				+ "3.Enter Two Strings Valid Starts with\n"
				+ "4.Enter Two Strings valid contains \n"
				+ "5.Enter Two Strings Endswith \n"
				+ "6.Enter Two Strings exactmatch\n"
				+ "7.List of String With MatcherString CASE_INSENSITIVe\n"
				+ "8.List of String with range of length\n"
				+ "9.Two List result mapped with Map\n"
				+ "10.Email Validation\n"
				+ "11.Html Code"
				+ "0.Exit");
		while(flag)
		{
			int choice=-1;
			try
			{
				choice = Integer.parseInt(scan.nextLine());
			}
			catch(NumberFormatException| InputMismatchException ex)
			{
				logger.log(Level.SEVERE, "Invalid Input");
			}
			switch (choice)
			{
			case 0:
			{
				flag = false;
				break;
			}
			case 1:
			{
				logger.log(Level.INFO,"Enter Mobile Number to Verify");
				String number = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.mobileNumberValidator(number);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 2:
			{
				logger.log(Level.INFO,"Enter Alpha Numeric String to Verify");
				String alphaNum = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.alphaNumericValidator(alphaNum);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 3:
			{
				logger.log(Level.INFO,"Enter Alpha Numeric String to Verify");
				String matchString = scan.nextLine();
				String testString = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.stringStarts(testString,matchString);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 4:
			{
				logger.log(Level.INFO,"Enter Alpha Numeric String to Verify");
				String matchString = scan.nextLine();
				String testString = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.stringContains(testString,matchString);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 5:
			{
				logger.log(Level.INFO,"Enter Alpha Numeric String to Verify");
				String matchString = scan.nextLine();
				String testString = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.stringEndsWith(testString,matchString);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 6:
			{
				logger.log(Level.INFO,"Enter Alpha Numeric String to Verify");
				String matchString = scan.nextLine();
				String testString = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.stringExactMatch(testString,matchString);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 7:
			{
				logger.log(Level.INFO,"Enter no of Strings to add");
				int limit = scan.nextInt();
				scan.nextLine();
				List<String> list = new ArrayList<>();
				for(int i=0;i<limit;i++)
				{
					logger.log(Level.INFO, "Enter String : ");
					list.add(scan.nextLine());
				}
				logger.log(Level.INFO, "Enter Matcher String");
				String matchString = scan.nextLine();
				Matcher result = null;
				try 
				{
					for(int i =0;i<limit;i++)
					{
						result = RegularExpressions.stringExactMatch(list.get(i), matchString, Pattern.CASE_INSENSITIVE);
						logger.log(Level.INFO,"Match Result : {0}" ,result.find());
					}
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}

				break;
			}
			case 8:
			{
				logger.log(Level.INFO,"Enter no of Strings to add");
				int limit = scan.nextInt();
				scan.nextLine();
				List<String> list = new ArrayList<>();
				for(int i=0;i<limit;i++)
				{
					logger.log(Level.INFO, "Enter String : ");
					list.add(scan.nextLine());
				}
				boolean result = false;
				try 
				{
					for(int i =0;i<limit;i++)
					{
						result = RegularExpressions.stringCountRange(list.get(i),6);
						logger.log(Level.INFO,"Match Result : {0}" ,result);
					}
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}

				break;
			}
			case 9:
			{
				// 2 list of strings and map
				logger.log(Level.INFO,"Enter no of Strings to add");
				int limit = scan.nextInt();
				scan.nextLine();
				List<String> list1 = new ArrayList<>();
				for(int i=0;i<limit;i++)
				{
					logger.log(Level.INFO, "Enter String : ");
					list1.add(scan.nextLine());
				}
				logger.log(Level.INFO,"Enter no of Strings to add");
				int limit2 = scan.nextInt();
				scan.nextLine();
				List<String> list2 = new ArrayList<>();
				for(int i=0;i<limit2;i++)
				{
					logger.log(Level.INFO, "Enter String : ");
					list2.add(scan.nextLine());
				}
				try 
				{
					Map<String,Integer> result = RegularExpressions.matchFinder(list1, list2);
					logger.log(Level.INFO, "{0}",result);
				}
				catch (CustomException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case 10:
			{
				logger.log(Level.INFO,"Enter email to Verify");
				String email = scan.nextLine();
				boolean result = false;
				try 
				{
					result = RegularExpressions.emailValidator(email);
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				logger.log(Level.INFO,"Match Result : {0}" ,result);
				break;
			}
			case 11:
			{
				logger.log(Level.INFO,"Enter html codes to Verify");
				//				String html = scan.nextLine();
				String html = "<p>The <code>President</code> of India is the first\n"
						+ "citizen of our country.</p>";
				Matcher result = null;
				int index =0;
				try 
				{
					result = RegularExpressions.tagfinder(html);
					while(result.find(index))
					{
						logger.log(Level.INFO,"Match Result : {0}\n" ,result.group());
						index = result.end();
					}
				} 
				catch (CustomException e) 
				{
					logger.log(Level.SEVERE, "EXCEPTION {} ",e.getMessage());
				}
				break;
			}
			}

		}
		scan.close();
	}
}
