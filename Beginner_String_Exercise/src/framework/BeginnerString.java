/**
 * 
 */
package framework;

/**
 * @author Balamurugan
 *
 */
public class BeginnerString
{	
	private void isNull(Object obj) throws CustomException
	{
		if(obj == null)
		{
			throw new CustomException("value should not be null");
		}
	}
	private void isNumValidRange(int number,int minRange,int maxRange) throws CustomException
	{
		if(number > maxRange || number < minRange)
		{
			throw new CustomException("Entered Number is Not in Range Expected");
		}
	}
	private void stringCheck(String string) throws CustomException
	{
		isNull(string);
		if(string.isEmpty())
		{
			throw new CustomException("Empty String Found");
		}
	}
	// returns the length of the string
	// arg - String	
	public int getLength(String string) throws CustomException
	{
		isNull(string);
		return string.length();		
	}
	// returns char array 	
	// arg - String
	public char[] strToCharArr(String string)  throws CustomException
	{
		stringCheck(string);
		return string.toCharArray();
	}
	// returns last occurance index of char in given string
	// arg - String,char
	public int lastIndexChar(String string,char fChar)  throws CustomException
	{	
		stringCheck(string);
		return string.lastIndexOf(fChar);
	}
	public char returnCharAt(String string,int index) throws CustomException
	{
		//stringCheck(string);
		isNumValidRange(index,0,getLength(string));
		return string.charAt(index);
		
	}
	// returns number of times given char is repeated in a given string
	public int numberOfOccurance(String string,char character)  throws CustomException
	{
		//stringCheck(string);
		int count=0,index=0,length=getLength(string);
		for(int i=0;i<length;i++)
		{
			if(string.charAt(i) == character)
			{
				count++;
			}
		}
		return count;
	}
	// returns substring of the given string with numberof chars and true for starting,false for ending
	// args
	public String getSubString(String string,int numOfChars,boolean start)  throws CustomException
	{	//todo: expection for isnum isboolean
		//stringCheck(string);
		int length = getLength(string);
		isNumValidRange(numOfChars,1,length);
		if(!start)
		{	
			return string.substring(length-numOfChars);
		}
		return string.substring(0,numOfChars);
	}
	// returns replace the string either from starting or ending 
	
	public String replaceString(String string,String newString,int noOfChars, boolean start)  throws CustomException
	{	
		stringCheck(newString);
		String subString = getSubString(string,noOfChars,start);
		return string.replace(subString,newString);
			
	}
	// returns the string starts with or end with
	
	public boolean startingEndingFinder(String string,String fString,boolean starts)  throws CustomException
	{	
		//stringCheck(string);
		//stringCheck(newString);
		int length1 = getLength(string),length2=getLength(fString);
		if(length1 < length2)
		{
			throw new CustomException("Find String should not be Greater than String");
		}	
		if(starts)
		{
			return string.startsWith(fString);
		}
		return string.endsWith(fString);
					
			
		
	}
	// converts the given string to upper or lower based of isUpper
	public String convertCase(String string,boolean upper) throws CustomException
	{
		stringCheck(string);
		//isNull(upper);
		if(upper)
		{
			return string.toUpperCase();
		}
		return string.toLowerCase();
	}
	public String stringReverse(String string)  throws CustomException
	{
		//stringCheck(string);
		String reversedString = "";
		int length = getLength(string);
		//reversedString += string.charAt(0);
		for(int i=0;i<length;i++)
		{
			char character = string.charAt(i);
			reversedString = character + reversedString;
		}
		return reversedString;
		
	}
	//todo : concatenate all elements of the String Array to single String
	public String concatenateArgs(String[] array)  throws CustomException
	{	
		isNull(array);
		String concateString = "";
		for(int i = 0;i< array.length;i++)
		{
			concateString += array[i];
		}
		return concateString;
		
	}
	// string to string array
	// needs to be without space
	public String[] strToArray(String string,String delimiter) throws CustomException
	{	
		stringCheck(string);
		isNull(delimiter);
		return string.split(delimiter);
	}
	public String concatenateAddArgs(String[] array,char delimiter) throws CustomException
	{	
		isNull(array);
		String concateString = "";
		for(int i = 0;i< array.length;i++)
		{
			concateString += array[i];
			if(i < array.length-1)
			{
				concateString +=delimiter;
			}
		}
		return concateString;
		
	}
	public boolean stringEqualWithCase(String string,String newString,boolean caseSensitive) throws CustomException
	{
		stringCheck(string);
		stringCheck(newString);
		if(!caseSensitive)
		{
			return string.equalsIgnoreCase(newString);
		}
		return string.equals(newString);
		
		
	}
	public String stringTrim(String string) throws CustomException
	{
		stringCheck(string);
		return string.trim();
		
	}
	
}
