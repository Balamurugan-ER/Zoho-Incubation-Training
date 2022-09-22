package com.bm.util;
public enum Utilities 
{
	VALID;
	public void isNull(Object obj) throws CustomException
	{
		if(obj == null)
		{
			throw new CustomException("value should not be null");
		}
	}
	public void isNumValidRange(int number,int minRange,int maxRange) throws CustomException
	{
		if(number > maxRange || number < minRange)
		{
			throw new CustomException("Entered Number is Not in Range Expected");
		}
	}
}
