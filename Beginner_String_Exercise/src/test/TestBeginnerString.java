/**
 * 
 */
package test;
import java.util.*;
import framework.*;
/**
 * @author Balamurugan
 *
 */
public class TestBeginnerString {


	private BeginnerString obj = new BeginnerString();
	private void task1(String string)  throws CustomException
	{
		int stringLength = obj.getLength(string);
		System.out.println(stringLength);
	}
	public void task2(String string)  throws CustomException
	{
		char[] charArr = obj.strToCharArr(string);
		System.out.println(charArr);
	}
	private void task3(String string) throws CustomException
	{
		int length = obj.getLength(string)-2;
		char lastIndex = obj.returnCharAt(string,length);
		System.out.println(lastIndex);
	}
	private void task4(String string,char c) throws CustomException
	{	
		int num = obj.numberOfOccurance(string,c);
		System.out.println(num);
	}
	private void task5(String string,char c) throws CustomException
	{
		int greatestPosition = obj.lastIndexChar(string,c);
		System.out.println(greatestPosition);
	}
	private void task6(String string,int numOfChars,boolean start) throws CustomException
	{
		String subString = obj.getSubString(string,numOfChars,start);
		System.out.println(subString);
	}
	private void task8(String originalString,String newSubString,int noOfChars, boolean start) throws CustomException
	{
		String updatedString = obj.replaceString(originalString,newSubString,noOfChars,start);
		System.out.println(updatedString);
	}
	private void task9(String string,String subString,boolean start) throws CustomException
	{
		boolean startsWith = obj.startingEndingFinder(string,subString,start);
		System.out.println(startsWith);
	}
	private void task11(String string1,boolean upper) throws CustomException
	{
		String convertedString = obj.convertCase(string1,upper);
		System.out.println(convertedString);
	}
	private void task13(String string) throws CustomException
	{
		String reversedString = obj.stringReverse(string);
		System.out.println(reversedString);
	}
	private void task15(String string) throws CustomException
	{
		String[] strArr = obj.strToArray(string," ");
		String concatString = obj.concatenateArgs(strArr);
		System.out.println(concatString);
	}
	//todo: error
	private void task16(String string) throws CustomException
	{
		String[] disArr = obj.strToArray(string," ");
		System.out.println(disArr);
	}
	private void task17(String string) throws CustomException
	{
		String[] strArr = obj.strToArray(string," ");	
		String concatString = obj.concatenateAddArgs(strArr,'-');
		System.out.println(concatString);
	}
	private void task18(String string1,String string2,boolean caseSensitive) throws CustomException
	{
		boolean equal = obj.stringEqualWithCase(string1,string2,caseSensitive);
		System.out.println(equal);
	}
	private void task20(String string) throws CustomException
	{
		String trimedString = obj.stringTrim(string);
		System.out.println(trimedString);
	}
	
	public static void main(String[] args) throws Exception
	{
		
		TestBeginnerString test = new TestBeginnerString();
		Scanner scan = new Scanner(System.in);
		String choice = null;
		boolean flag = true;
		try
		{
			
			System.out.println("Scanner welcome");
			System.out.println("1. Enter string to find Length : ");
			System.out.println("2. Enter string to Convert into Char Array : ");
			System.out.println("3. Send me string and char \nI will send you last Index Of your Char : ");		
			System.out.println("4. Send me string and char \nI will send you No of Times it Repeated : ");
			System.out.println("5. Send me string and char \nI will send you Greatest Position of it : ");
			System.out.println("6. I give first/last n character of string ");
			System.out.println("7. I replace the chars with your substring from (first/last)");
			System.out.println("8. Substring is found or not");
			System.out.println("9. to convert case  lower/upper : ");
			System.out.println("10. Enter String to reverse : ");
			System.out.println("11. Read multiple string Space Separated. ");
			System.out.println("12. Remove Space in a string ");
			System.out.println("13. String to string array ");
			System.out.println("14. Strings space are removed concanated with '-' ");
			System.out.println("15. Strings equal or not ");
			System.out.println("16. Trimes the Spaces in String ");
			System.out.println("0. Exit ");
			
			while(flag)
			{
			System.out.println("Enter your choice (1-16)");
			int n = scan.nextInt();
			if(n < 0 && n > 16)
			{
				throw new CustomException("Invalid Choice Range");
			}
				switch (n)
				{
				case 1:
				 {
				 	System.out.println("Enter string to find Length : ");
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
				 	System.out.println("Enter string to Convert into Char Array : ");					
				 	scan.nextLine();
				 	String string = scan.nextLine();
				 	test.task2(string);
				 	break;
				 } 
				 case 3:
				 {
				 	System.out.println("Enter String : ");
				 	String string = scan.next();
				 	test.task3(string);
				 	break;
				 }
				 case 4:
				 {
				 	System.out.println("Send me string and char \nI will send you No of Times it Repeated : ");
				 	System.out.println("Enter String : ");
				 	String string = scan.next();
				 	System.out.println("Enter char : ");
				 	char ch = scan.next().charAt(0);
				 	test.task4(string,ch);
				 	break;
				 }
				 case 5:
				 {
				 	System.out.println("Send me string and char \nI will send you Greatest Position of it : ");
				 	System.out.println("Enter String : ");
				 	String string = scan.next();
				 	System.out.println("Enter char : ");
				 	char ch = scan.next().charAt(0);
				 	test.task5(string,ch);
				 	break;
				 } 
				 case 6:
				 {
				 	System.out.println("I give first/last n character of string \n1.string\n2.Number\n3.True(first N characters)\nfalse(Last N characters) : ");
				 	String string = scan.next();
				 	System.out.println("Enter Number :");
				 	int number = scan.nextInt();
				 	System.out.println("Enter boolean :");
				 	boolean first = scan.nextBoolean();
				 	test.task6(string,number,first);
				 	break;
				 }
				 case 7:
				 {
				 	System.out.println("give me followings \n1.string\n2.Number\n3.True(first N characters)\nfalse(Last N characters) :\n I replace the chars with your substring from (first/last) based on your boolean ");
				 	System.out.println("Enter String : ");
				 	String string = scan.next();
				 	scan.nextLine();
				 	System.out.println("Enter Sub String : ");
				 	String subString = scan.next();
				 	System.out.println("Enter Number :");
				 	int number = scan.nextInt();
				 	System.out.println("Enter boolean :");
				 	boolean first = scan.nextBoolean();
				 	test.task8(string,subString,number,first);
				 	break;
				 }
				 case 8:
				 {
				 	System.out.println("\n1.string\n2.Number\n3.True(first N)\nfalse(Last) : \nSubstring is found or not");
				 	System.out.println("Enter String : ");
				 	String string = scan.next();
				 	System.out.println("Enter Sub String : ");
				 	String subString = scan.next();
				 	System.out.println("Enter boolean :");
				 	boolean first = scan.nextBoolean();
				 	test.task9(string,subString,first);
				 	break;
				 }
				 case 9:
				 {
				 	System.out.println("Enter string and boolean to convert case \n True/false for lower/upper : ");
				 	System.out.println("Enter String : ");
				 	String string = scan.next();
					System.out.println("Enter boolean :");
				 	boolean fromFirst = scan.nextBoolean();
				 	test.task11(string,fromFirst);
				 	break;
				 }
				 case 10:
				 {
				 	System.out.println("Enter String to reverse : ");
				 	String string = scan.next();
				 	test.task13(string);
				 	break;
				 }
				 case 11:
				 {
				 	System.out.println("Enter multiple string : ");
				 	System.out.println("enter your string) : ");
				 	scan.nextLine();
				 	String string = scan.nextLine();
				 	System.out.println(string);
				 	break;
				 }  
				 // task 15
				 case 12:
				 {
				 	System.out.println("Enter multiple string : ");
				 	scan.nextLine();
				 	String string = scan.nextLine();
				 	test.task15(string);
				 	break;
				 }
				 case 13:
				 {
				 	System.out.println("Enter multiple string : ");
				 	scan.nextLine();
				 	String string = scan.nextLine();
				 	test.task16(string);
				 	break;
				 }
				 case 14:
				 {
				 	System.out.println("Enter multiple string : ");
				 	System.out.println("enter your string) : ");
				 	scan.nextLine();
				 	String string = scan.nextLine();
				 	test.task17(string);
				 	break;
				 }
				 case 15:
				 {
				 	System.out.println("\n1.string\n2.Number\n3.True(case Sensitive)\nfalse(case Insensitive) : i will return both string equal or not");
				 	System.out.println("Enter first String : ");
				 	String string = scan.next();
				 	System.out.println("Enter second String : ");
				 	String subString = scan.next();
				 	System.out.println("Enter boolean :");
				 	boolean first = scan.nextBoolean();
				 	test.task18(string,subString,first);
				 	break;
				 }
				 case 16:
				 {
				 	System.out.println("Enter multiple string : ");
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
				}		
			}
					
		}
		catch(CustomException e)
		{
			System.out.println(e);
		}
		catch(InputMismatchException e)
		{
			System.out.println(" Invalid input ! \n kindly check and run!!");
		}
				
	}


}
