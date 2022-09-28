/**
 * 
 */
package com.bm.testrunner;

import org.json.JSONObject;

import com.bm.framework.httprequest.AccountsInfo;

/**
 * @author Balamurugan
 *
 */
public class TestHttpRequest 
{
	public static void main(String[] args)
	{
		AccountsInfo accounts = new AccountsInfo();
		try
		{
			JSONObject json = accounts.getUserInfo();
			System.out.println(json);			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
