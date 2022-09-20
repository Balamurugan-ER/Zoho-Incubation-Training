/**
 * 
 */
package com.bm.framework.stringbuilder;
import com.bm.util.*;
import java.util.Objects;
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
		catch(NullPointerException e)
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
		Utilities.isNumValidRange(index, 0, getsbLength(sbString)); //TODO: index maximum range
		return sbString.insert(index, string);
	}
	public int findDelimiter(StringBuilder sbString,char delimiter,boolean first) throws CustomException
	{
		checkNull(sbString);
		if(first)
		{
			return sbString.toString().indexOf(delimiter);
		}
		return sbString.toString().lastIndexOf(delimiter);
	}
	public void deleteRange(StringBuilder sbString,int start,int end) throws CustomException
	{
		int length = getsbLength(sbString);
		Utilities.isNumValidRange(start, 0, length);
		sbString.delete(start, end);
	}
	public String[] sbStrToArray(StringBuilder sbString,String delimiter)
	{
		String string = Objects.toString(sbString);
		return string.split(delimiter);
	}
	public StringBuilder sbConcat(StringBuilder sbString,String delimiter) throws CustomException
	{
		checkNull(sbString);
		String[] array = sbStrToArray(sbString," ");
		
		StringBuilder concateString = createSBuilder();

		for(int i = 0;i< array.length;i++)
		{
			addString(concateString,array[i]);
			if(i < array.length-1)
			{
				addString(concateString,delimiter);
			}
		}
		return sbString=concateString;
	}
	//TODO debug unfinished
	public StringBuilder sbReplace(StringBuilder sbString,int start,int end,String subString) throws CustomException
	{
		checkNull(subString);
		int length = getsbLength(sbString);
		Utilities.isNumValidRange(start, 0, length);
		return sbString.replace(start, end, subString);
	}
	public StringBuilder sbReverse(StringBuilder sbString) throws CustomException
	{
		checkNull(sbString);
		return sbString.reverse();
	}



}


