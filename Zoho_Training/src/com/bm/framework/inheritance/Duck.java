package com.bm.framework.inheritance;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Balamurugan
 *
 */


public class Duck extends Bird 
{
	private static Logger logger = Logger.getLogger(Bird.class.getName());
	@Override
	public void speak()
	{
		logger.log(Level.INFO,"Speaking");
	}
}