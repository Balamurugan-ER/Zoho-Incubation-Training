/**
 * 
 */
package com.zoho.bm.framework;

import java.util.Objects;
import com.zoho.bm.util.*;
/**
 * @author inc5
 *
 */
public class BstringBuilder {


	public void checkNull(Object sbString) throws CustomException
	{	
		try
		{
			Objects.requireNonNull(sbString, "Value should not be null");
		}
		catch(Exception e)
		{
			throw new CustomException("Null Value Found");
		}

	}

	public int getsbLength(StringBuilder sbString) throws CustomException
	{
		checkNull(sbString);
		return sbString.length();
	}

	public StringBuilder createSBuilder()
	{
		return new StringBuilder();
	}
	public StringBuilder createSBuilder(String string)
	{
		return new StringBuilder(string);
	}
	public int getCapacity(StringBuilder sbString) throws CustomException
	{
		checkNull(sbString);
		return sbString.capacity();
	}
	public StringBuilder addString(StringBuilder sbString,String newString) throws CustomException
	{	
		checkNull(sbString);
		checkNull(newString);
		return sbString.append(newString);
	}
	public StringBuilder addString(StringBuilder sbString,int index,String string) throws CustomException
	{
		checkNull(string);
		Utilities.isNumValidRange(index, 0, getsbLength(sbString));
		return sbString.insert(index, string);
	}
	public void findDelimiter(StringBuilder sbString,char delimiter) throws CustomException
	{
		checkNull(sbString);
		int value;
//		System.out.println();
		System.out.println(sbString.toString().charAt(delimiter));
	}
	public StringBuilder deleteRange(StringBuilder sbString,int start,int end) throws CustomException
	{
		int length = getsbLength(sbString);
		Utilities.isNumValidRange(start, 0, length);
		return sbString.delete(start, end);
	}
	public String[] sbStrToArray(StringBuilder sbString,String delimiter)
	{
		String string = Objects.toString(sbString);
		return string.split(string);
	}
	public StringBuilder sbConcat(StringBuilder sbString,char delimiter) throws CustomException
	{
		checkNull(sbString);
		String[] array = sbStrToArray(sbString," ");
		String concateString = "";

		for(int i = 0;i< array.length;i++)
		{
			concateString += array[i];
			if(i < array.length-1)
			{
				concateString +=delimiter;
			}
		}

		return createSBuilder(concateString);
	}
	public StringBuilder sbReplace(StringBuilder sbString,int start,int end) throws CustomException
	{
		int length = getsbLength(sbString);
		Utilities.isNumValidRange(start, 0, length);
		return sbString.replace(start, end, sbString.toString());

	}



}


