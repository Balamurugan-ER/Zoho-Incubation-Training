/**
 * 
 */
package com.bm.testrunner;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bm.framework.String.*;
import com.bm.util.*;
/**
 * @author Balamurugan
 *
 */
public class TestBeginnerString {


	private BeginnerString obj = new BeginnerString();
	private static Logger logger = Logger.getLogger(TestBeginnerString.class.getName());
	private void task1(String string)  throws CustomException
	{
		int stringLength = obj.getLength(string);
		logger.log(Level.INFO,"{0}",stringLength);
	}
	public void task2(String string)  throws CustomException
	{
		char[] charArr = obj.strToCharArr(string);
		logger.log(Level.INFO,"{0}",charArr);
	}
	private void task3(String string) throws CustomException
	{
		int length = obj.getLength(string)-2;
		char lastIndex = obj.returnCharAt(string,length);
		logger.log(Level.INFO,"{0}",lastIndex);
	}
	private void task4(String string,char c) throws CustomException
	{	
		int num = obj.numberOfOccurance(string,c);
		logger.log(Level.INFO,"{0}",num);
	}
	private void task5(String string,char c) throws CustomException
	{
		int greatestPosition = obj.lastIndexChar(string,c);
		logger.log(Level.INFO,"{0}",greatestPosition);
	}
	private void task6(String string,int numOfChars,boolean start) throws CustomException
	{
		String subString = obj.getSubString(string,numOfChars,start);
		logger.log(Level.INFO,subString);
	}
	private void task8(String originalString,String newSubString,int noOfChars, boolean start) throws CustomException
	{
		String updatedString = obj.replaceString(originalString,newSubString,noOfChars,start);
		logger.log(Level.INFO,updatedString);
	}
	private void task9(String string,String subString,boolean start) throws CustomException
	{
		boolean startsWith = obj.startingEndingFinder(string,subString,start);
		logger.log(Level.INFO,"{0}",startsWith);
	}
	private void task11(String string1,boolean upper) throws CustomException
	{
		String convertedString = obj.convertCase(string1,upper);
		logger.log(Level.INFO,"{0}",convertedString);
	}
	private void task13(String string) throws CustomException
	{
		String reversedString = obj.stringReverse(string);
		logger.log(Level.INFO,reversedString);
	}
	private void task15(String string) throws CustomException
	{
		String[] strArr = obj.strToArray(string," ");
		String concatString = obj.concatenateArgs(strArr);
		logger.log(Level.INFO,concatString);
	}
	//todo: error
	private void task16(String string) throws CustomException
	{
		String[] disArr = obj.strToArray(string," ");
		logger.log(Level.INFO,"{0}",disArr);
	}
	private void task17(String string) throws CustomException
	{
		String[] strArr = obj.strToArray(string," ");	
		String concatString = obj.concatenateAddArgs(strArr,'-');
		logger.log(Level.INFO,concatString);
	}
	private void task18(String string1,String string2,boolean caseSensitive) throws CustomException
	{
		boolean equal = obj.stringEqualWithCase(string1,string2,caseSensitive);
		logger.log(Level.INFO,"{0}",equal);
	}
	private void task20(String string) throws CustomException
	{
		String trimedString = obj.stringTrim(string);
		logger.log(Level.INFO,trimedString);
	}

	public static void main(String[] args) throws Exception
	{

		TestBeginnerString test = new TestBeginnerString();
		Scanner scan = new Scanner(System.in);
		String choice = null;
		boolean flag = true;
		try
		{
			
			logger.log(Level.INFO,"Scanner welcome\n"
					+ "1. Enter string to find Length : \n"
					+ "2. Enter string to Convert into Char Array : \n"
					+ "3. Send me string and char \\nI will send you last Index Of your Char : \n"
					+ "4. Send me string and char \\nI will send you No of Times it Repeated : \n"
					+ "5. Send me string and char \\nI will send you Greatest Position of it : \n"
					+ "6. I give first/last n character of string \n"
					+ "7. I replace the chars with your substring from (first/last)\n"
					+ "8. Substring is found or not\n"
					+ "9. to convert case  lower/upper : \n"
					+ "10. Enter String to reverse : \n"
					+ "11. Read multiple string Space Separated. \n"
					+ "12. Remove Space in a string \n"
					+ "13. String to string array \n"
					+ "14. Strings space are removed concanated with '-' \n"
					+ "15. Strings equal or not \n"
					+ "16. Trimes the Spaces in String \n"
					+ "0. Exit \n"
					+ "1000.SanityCheck");
			while(flag)
			{
				logger.log(Level.INFO,"Enter your choice (1-16)");
				int n = scan.nextInt();
				if(n < 0 && n > 16)
				{
					throw new CustomException("Invalid Choice Range");
				}
				switch (n)
				{
				case 1:
				{
					logger.log(Level.INFO,"Enter string to find Length : ");
					//String string = scan.next();
					if(args != null)
					{
						test.task1(args[0]);
						break;
					}
					else
					{
						throw new CustomException("Invalid Argument");	
					}

				}
				case 2:
				{
					logger.log(Level.INFO,"Enter string to Convert into Char Array : ");					
					scan.nextLine();
					String string = scan.nextLine();
					test.task2(string);
					break;
				} 
				case 3:
				{
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					test.task3(string);
					break;
				}
				case 4:
				{
					logger.log(Level.INFO,"Send me string and char \nI will send you No of Times it Repeated : ");
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					logger.log(Level.INFO,"Enter char : ");
					char ch = scan.next().charAt(0);
					test.task4(string,ch);
					break;
				}
				case 5:
				{
					logger.log(Level.INFO,"Send me string and char \nI will send you Greatest Position of it : ");
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					logger.log(Level.INFO,"Enter char : ");
					char ch = scan.next().charAt(0);
					test.task5(string,ch);
					break;
				} 
				case 6:
				{
					logger.log(Level.INFO,"I give first/last n character of string \n1.string\n2.Number\n3.True(first N characters)\nfalse(Last N characters) : ");
					String string = scan.next();
					logger.log(Level.INFO,"Enter Number :");
					int number = scan.nextInt();
					logger.log(Level.INFO,"Enter boolean :");
					boolean first = scan.nextBoolean();
					test.task6(string,number,first);
					break;
				}
				case 7:
				{
					logger.log(Level.INFO,"give me followings \n1.string\n2.Number\n3.True(first N characters)\nfalse(Last N characters) :\n I replace the chars with your substring from (first/last) based on your boolean ");
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					scan.nextLine();
					logger.log(Level.INFO,"Enter Sub String : ");
					String subString = scan.next();
					logger.log(Level.INFO,"Enter Number :");
					int number = scan.nextInt();
					logger.log(Level.INFO,"Enter boolean :");
					boolean first = scan.nextBoolean();
					test.task8(string,subString,number,first);
					break;
				}
				case 8:
				{
					logger.log(Level.INFO,"\n1.string\n2.Number\n3.True(first N)\nfalse(Last) : \nSubstring is found or not");
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					logger.log(Level.INFO,"Enter Sub String : ");
					String subString = scan.next();
					logger.log(Level.INFO,"Enter boolean :");
					boolean first = scan.nextBoolean();
					test.task9(string,subString,first);
					break;
				}
				case 9:
				{
					logger.log(Level.INFO,"Enter string and boolean to convert case \n True/false for lower/upper : ");
					logger.log(Level.INFO,"Enter String : ");
					String string = scan.next();
					logger.log(Level.INFO,"Enter boolean :");
					boolean fromFirst = scan.nextBoolean();
					test.task11(string,fromFirst);
					break;
				}
				case 10:
				{
					logger.log(Level.INFO,"Enter String to reverse : ");
					String string = scan.next();
					test.task13(string);
					break;
				}
				case 11:
				{
					logger.log(Level.INFO,"Enter multiple string : ");
					logger.log(Level.INFO,"enter your string) : ");
					scan.nextLine();
					String string = scan.nextLine();
					logger.log(Level.INFO,string);
					break;
				}  
				// task 15
				case 12:
				{
					logger.log(Level.INFO,"Enter multiple string : ");
					scan.nextLine();
					String string = scan.nextLine();
					test.task15(string);
					break;
				}
				case 13:
				{
					logger.log(Level.INFO,"Enter multiple string : ");
					scan.nextLine();
					String string = scan.nextLine();
					test.task16(string);
					break;
				}
				case 14:
				{
					logger.log(Level.INFO,"Enter multiple string : ");
					logger.log(Level.INFO,"enter your string) : ");
					scan.nextLine();
					String string = scan.nextLine();
					test.task17(string);
					break;
				}
				case 15:
				{
					logger.log(Level.INFO,"\n1.string\n2.Number\n3.True(case Sensitive)\nfalse(case Insensitive) : i will return both string equal or not");
					logger.log(Level.INFO,"Enter first String : ");
					String string = scan.next();
					logger.log(Level.INFO,"Enter second String : ");
					String subString = scan.next();
					logger.log(Level.INFO,"Enter boolean :");
					boolean first = scan.nextBoolean();
					test.task18(string,subString,first);
					break;
				}
				case 16:
				{
					logger.log(Level.INFO,"Enter multiple string : ");
					scan.nextLine();
					String string = scan.nextLine();
					test.task20(string);
					break;
				}
				case 0:
				{
					flag = false;
					break;
				} 
				case 1000:
				{
					Utilities.INST.check("com.bm.framework.String.BeginnerString");
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
			logger.log(Level.SEVERE," Invalid input ! \n kindly check and run!!");
		}

	}


}
