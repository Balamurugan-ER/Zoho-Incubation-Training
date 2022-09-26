/**
 * 
 */
package com.bm.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * @author balamurugan
 *
 */
public class SanityCheck
{
	public void check(Class classname) throws CustomException
	{		
		int passedCount=0,failedCount=0;
		try 
		{
			Class classObject = Class.forName("com.bm.framework.String.BeginnerString");
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
//					System.out.println(classObj);
					String classTypeObj=param.getParameterizedType().toString();

					if(param.getType().isPrimitive())
					{
						if(param.getType().toString().equals("boolean"))
						{
//							System.out.println("boolean");
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
//					System.out.println(param.getType());
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
					
//					System.out.println(e.getCause());
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
//	public static void main(String[] args)
//	{
//		SanityCheck checkObj = new SanityCheck();
//		try {
//			checkObj.check();
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			System.out.println("passed");
////			main(args);
//		}
//	}
}
