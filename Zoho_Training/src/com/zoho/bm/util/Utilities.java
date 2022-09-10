package com.zoho.bm.util;

import com.zoho.bm.framework.*;
public class Utilities {
	
	public static void isNull(Object obj) throws CustomException
	{
		if(obj == null)
		{
			throw new CustomException("value should not be null");
		}
	}
	public static void isNumValidRange(int number,int minRange,int maxRange) throws CustomException
	{
		if(number > maxRange || number < minRange)
		{
			throw new CustomException("Entered Number is Not in Range Expected");
		}
	}
}
