package com.bm.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public enum Utilities 
{
	INST;
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
	public void check(String className) throws CustomException
	{		
		int passedCount=0,failedCount=0;
		try 
		{
//			Class classObject = Class.forName("com.bm.framework.String.BeginnerString");
			Class classObject = Class.forName(className);
			Object obj = classObject.newInstance();
			Method[] methodObject = classObject.getDeclaredMethods();

			for(Method methodIterator : methodObject)
			{
				Parameter[] parameter = methodIterator.getParameters();
				Object[] paramValues = new Object[parameter.length];

				int i = 0;
				System.out.println(methodIterator.getName());
				for(Parameter param : parameter)
				{
					String classObj=param.getType().toString();
					String classTypeObj=param.getParameterizedType().toString();

					if(param.getType().isPrimitive())
					{
						if(param.getType().toString().equals("boolean"))
						{
							paramValues[i++] = false;
						}
						if(param.getType().toString().equals("int"))
						{
							paramValues[i++] = 0;
						}
						if(param.getType().toString().equals("char"))
						{
							paramValues[i++]='a';
						}
					}
					else
					{
						paramValues[i++] = null;
					}
				}			
				methodIterator.setAccessible(true);
				try {
					methodIterator.invoke(obj,paramValues);
				} 
				catch (InvocationTargetException e) {
					if(e.getCause() instanceof CustomException)
					{
						passedCount++;
						System.out.println("passed "+methodIterator.getName());
					}
					else
					{
						failedCount++;
						System.out.println("failed "+methodIterator.getName());
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(passedCount+" Cases Passed");
		System.out.println(failedCount+" Failed Cases");
	}

}
