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
public class TestPlayWithJson 
{
	
	public static void main(String[] args)
	{
//		PlayWithJson play = new PlayWithJson();
		AccountsInfo accounts = new AccountsInfo();
		try
		{
			JSONObject json = accounts.getUserInfo();
			System.out.println(json);
			
//			System.out.println(json.createJson("example.json"));
//			System.out.println(json.parseJsonFile("example.json"));
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}