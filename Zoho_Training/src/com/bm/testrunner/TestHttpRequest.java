/**
 * 
 */
package com.bm.testrunner;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONObject;

import com.bm.framework.httprequest.ZohoApiRequest;

/*
 * @author Balamurugan
 */
public class TestHttpRequest 
{
	private static Logger logger = Logger.getLogger(TestHttpRequest.class.getName());
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
	{
		ZohoApiRequest accounts = new ZohoApiRequest();
		try
		{
			logger.log(Level.INFO,"Enter url");
			String url = scan.next();
			logger.log(Level.INFO,"Enter Client_id");
			String client_id = scan.next();
			logger.log(Level.INFO,"Enter Client_secret");
			String client_secret = scan.next();
			logger.log(Level.INFO,"Enter Code");
			String code = scan.next();
			logger.log(Level.INFO,"Enter grant_type/nex. authorization_code");
			String grant_type = scan.next();
			logger.log(Level.INFO,"Enter redirect_uri/nex. http://");
			String redirect_uri = scan.next();
			JSONObject json = accounts.getInfo(url,client_id,client_secret,code,grant_type,redirect_uri);
			logger.log(Level.INFO,"{0}",json);			
		} 
		catch (Exception e)
		{
			logger.log(Level.INFO,e.getMessage());
		}
	}
}
