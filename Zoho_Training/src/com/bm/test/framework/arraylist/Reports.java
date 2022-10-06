package com.bm.test.framework.arraylist;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Reports {
	static Logger logger = Logger.getLogger(Reports.class.getName());
	public static void main(String[] args) 
	{
		Result result = JUnitCore.runClasses();
		for(Failure failure : result.getFailures())
		{
			logger.log(Level.INFO,failure.toString());
		}
		logger.log(Level.INFO,"{0}", result.wasSuccessful());
	}

}
