/**
 * 
 */
package com.bm.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author balamurugan
 *
 */
public class SanityCheck
{
	public static boolean check()
	{
		try 
		{
			Class classObject = Class.forName("com.bm.framework.String.BeginnerString");
			//Constructor<?> constructorObj = (Constructor<?>) classObject.newInstance();
			Method[] methodObject = classObject.getDeclaredMethods();
			
			for(Method methodIterator : methodObject)
			{
				Parameter[] parameter = methodIterator.getParameters();
				Class[] paramValues = new Class[parameter.length];
//				System.out.println(parameter.length);
				System.out.println(methodIterator);
				for(Parameter param : parameter)
				{
//					System.out.println(param.getDeclaringExecutable());
//					System.out.println(param.getModifiers()); //come back
					check1:
					if(parameter.length == 1)
					{
						System.out.println("Check Param : "+param.getName());
						methodIterator.setAccessible(true);
						methodIterator.invoke(null);
					}
					check2:
					if(parameter.length == 2)
					{
						System.out.println("Check Param : "+param.getName());
						methodIterator.setAccessible(true);
						methodIterator.invoke(null,null);
					}
//					System.out.println(param.getParameterizedType());
//					System.out.print(param.getName());
//					if(param.getParameterizedType().equals("class java.lang.Object"))
//					{
//						System.out.println("I found way boy ");
//					}
					
				}
				//methodIterator.invoke(parameter);		
				
			}
		}
		catch(NullPointerException e)
		{
			//e.printStackTrace();
			System.out.println("Null Check Passed");
			//check2();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}  
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public static void main(String[] args)
	{
		SanityCheck.check();
	}
}
