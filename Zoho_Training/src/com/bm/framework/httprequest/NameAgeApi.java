/**
 * 
 */
package com.bm.framework.httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;
/**
 * @author Balamurugan
 *
 */
public class NameAgeApi 
{
	public static void main(String[] args)
	{
		URL url;
		try 
		{
			String name = "swami";
			url = new URL("https://api.agify.io/?name="+name);
			HttpsURLConnection secureCon = (HttpsURLConnection) url.openConnection();
			System.out.println(secureCon.getHeaderFields());
			System.out.println(secureCon.getResponseCode());
			System.out.println(secureCon.getResponseMessage());
			BufferedReader bf = new BufferedReader(new InputStreamReader(secureCon.getInputStream()));
			JSONObject json = new JSONObject(bf.readLine());
			System.out.println(json);
			System.out.println("Age  : "+json.getInt("age"));
			System.out.println("Name : "+json.getString("name"));
			bf.close();
			secureCon.disconnect();
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
