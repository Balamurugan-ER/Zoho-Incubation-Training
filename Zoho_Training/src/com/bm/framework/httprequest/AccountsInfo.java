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
public class AccountsInfo
{
	public JSONObject getUserInfo()
	{
		String url = "https://accounts.zoho.com/oauth/user/info";
		String accessToken ="1000.2f632c0fb9eb10102f7bc66726d56bb2.2fe5914fcfc15458324979d9e9d41fe7";
		JSONObject json = null;
		try 
		{
			URL urlobject = new URL(url);
			HttpsURLConnection connection = (HttpsURLConnection) urlobject.openConnection();
			connection.setRequestProperty("Authorization","Zoho-oauthtoken "+accessToken);
			int resCode = connection.getResponseCode();
			BufferedReader bf;
			if(resCode >= 200 && resCode <= 399)
			{
				bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			else
			{
				bf = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			json = new JSONObject(bf.readLine());
			bf.close();
		}
		catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		} catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
		return json;
	}
}
