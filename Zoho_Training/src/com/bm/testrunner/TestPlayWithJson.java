/**
 * 
 */
package com.bm.testrunner;

import org.json.JSONObject;

import com.bm.framework.json.PlayWithJson;
import com.bm.util.CustomException;

/**
 * @author Balamurugan
 *
 */
public class TestPlayWithJson 
{
	
	public static void main(String[] args)
	{
		PlayWithJson json = new PlayWithJson();
		try
		{
			System.out.println(json.createJson("example.json"));
			System.out.println(json.parseJsonFile("example.json"));
		} 
		catch (CustomException e)
		{
			e.printStackTrace();
		}
	}
}
