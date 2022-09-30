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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author balamurugan
 *
 */
public class SanityCheck
{
	Logger logger = Logger.getLogger(SanityCheck.class.getName());
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
				logger.log(Level.INFO,methodIterator.getName());
				for(Parameter param : parameter)
				{
					String classObj=param.getType().toString();
//					logger.log(classObj);
					String classTypeObj=param.getParameterizedType().toString();

					if(param.getType().isPrimitive())
					{
						if(param.getType().toString().equals("boolean"))
						{
//							logger.log("boolean");
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
//					logger.log(param.getType());
				}			
				methodIterator.setAccessible(true);
				try {
					methodIterator.invoke(obj,paramValues);
				} 
				catch (InvocationTargetException e) {
					if(e.getCause() instanceof CustomException)
					{
						passedCount++;
						logger.log(Level.INFO,"passed "+methodIterator.getName());
					}
					else
					{
						failedCount++;
						logger.log(Level.INFO,"failed "+methodIterator.getName());
					}
					
//					logger.log(e.getCause());
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.log(Level.WARNING,passedCount+" Cases Passed");
		logger.log(Level.SEVERE,failedCount+" Failed Cases");
	}
//	public static void main(String[] args)
//	{
//		SanityCheck checkObj = new SanityCheck();
//		try {
//			checkObj.check();
//		} catch (CustomException e) {
//			// TODO Auto-generated catch block
//			logger.log("passed");
////			main(args);
//		}
//	}
}
