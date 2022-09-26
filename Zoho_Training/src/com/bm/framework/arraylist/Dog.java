package com.bm.framework.arraylist;

import com.bm.util.CustomException;
import com.bm.util.Utilities;

public class Dog
{
	public Dog(String name) throws CustomException
	{
		Utilities.VALID.isNull(name);
		this.name = name;
	}
	private String name;
	public String getName()
	{
		return this.name;
	}
	@Override
	public String toString()
	{
		return this.name;
	}
}