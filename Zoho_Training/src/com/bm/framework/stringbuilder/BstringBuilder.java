/**
 * 
 */
package com.bm.framework.stringbuilder;
import com.bm.util.*;

import java.util.Objects;
/**
 * @author Balamurugan
 *
 */
public class BstringBuilder 
{

	// returns length of the stringBuilder
	public int getsbLength(StringBuilder sbString) throws CustomException
	{
		Utilities.INST.isNull(sbString);
		return sbString.length();
	}
	// returns an empty string builder
	public StringBuilder createSBuilder()
	{
		return new StringBuilder();
	}
	// returns an stringbuilder by calling custom constructor string.
	public StringBuilder createSBuilder(String string) throws CustomException
	{
		Utilities.INST.isNull(string);
		return new StringBuilder(string);
	}
	// returns the capacity of the stringbuilder
	public int getCapacity(StringBuilder sbString) throws CustomException
	{
		Utilities.INST.isNull(sbString);
		return sbString.capacity();
	}
	// returns the StringBuilder by adding new String to it.
	public StringBuilder addString(StringBuilder sbString,String newString) throws CustomException
	{	
		Utilities.INST.isNull(sbString);
		return sbString.append(newString);
	}
	// returns the String builder by adding string at given index.
	public StringBuilder addString(StringBuilder sbString,int index,String string) throws CustomException
	{
		Utilities.INST.isNull(string);
		Utilities.INST.isNumValidRange(index, 0, getsbLength(sbString)); //TODO: index maximum range
		return sbString.insert(index, string);
	}
	// returns the first index or last index of given char in a stringBuilder.
	public int findDelimiter(StringBuilder sbString,char delimiter,boolean first) throws CustomException
	{
		Utilities.INST.isNull(sbString);
		if(first)
		{
			return sbString.toString().indexOf(delimiter);
		}
		return sbString.toString().lastIndexOf(delimiter);
	}
	// deletes the range of chars in given StringBuilder.
	public void deleteRange(StringBuilder sbString,int start,int end) throws CustomException
	{
		int length = getsbLength(sbString);
		Utilities.INST.isNumValidRange(start, 0, length);
		sbString.delete(start, end);
	}
	// returns the String array by spliting the StringBuilder with given delimiter.
	public String[] sbStrToArray(StringBuilder sbString,String delimiter) throws CustomException
	{
		Utilities.INST.isNull(sbString);
		String string = Objects.toString(sbString);
		return string.split(delimiter);
	}
	// returns the StringBuilder by appending delimiter at each white space.
	public StringBuilder sbConcat(StringBuilder sbString,String delimiter) throws CustomException
	{
		Utilities.INST.isNull(sbString);
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
	// returns the StringBuilder by replacing the String at the specified start and end index.
	public StringBuilder sbReplace(StringBuilder sbString,int start,int end,String subString) throws CustomException
	{
		Utilities.INST.isNull(subString);
		int length = getsbLength(sbString);
		Utilities.INST.isNumValidRange(start, 0, length);
		return sbString.replace(start, end, subString);
	}
	// returns reversed StringBuilder
	public StringBuilder sbReverse(StringBuilder sbString) throws CustomException
	{
		Utilities.INST.isNull(sbString);
		return sbString.reverse();
	}
}


