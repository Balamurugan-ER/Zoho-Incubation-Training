/**
 * 
 */
package com.bm.testrunner;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.bm.framework.httprequest.AccountsInfo;

/**
 * @author Balamurugan
 *
 */
public class TestHttpRequest 
{
	private static Logger logger = Logger.getLogger(TestHttpRequest.class.getName());
	public static void main(String[] args)
	{
		AccountsInfo accounts = new AccountsInfo();
		try
		{
			JSONObject json = accounts.getUserInfo();
			logger.log(Level.INFO,"{0}",json);			
		} 
		catch (Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
	}
}
