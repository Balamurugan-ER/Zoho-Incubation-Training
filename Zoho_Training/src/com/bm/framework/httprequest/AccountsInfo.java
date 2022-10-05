/**
 * 
 */
package com.bm.framework.httprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

import com.bm.util.CustomException;
/**
 * @author Balamurugan
 *
 */
public class AccountsInfo
{
	
	public JSONObject requestUrl(String url,String accessToken,String type) throws CustomException
	{
		JSONObject json = null;
		BufferedReader bf = null;
		try 
		{
			URL urlobject = new URL(url);
			HttpsURLConnection connection = (HttpsURLConnection) urlobject.openConnection();
			connection.setRequestMethod(type);
			if(accessToken != null)
			{
				connection.setRequestProperty("Authorization","Zoho-oauthtoken "+accessToken);
			}
			int resCode = connection.getResponseCode();
			if(resCode >= 200 && resCode <= 399)
			{
				bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			}
			else
			{
				bf = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
			}
			json = new JSONObject(bf.readLine());
		}
		catch (MalformedURLException e) 
		{
			throw new CustomException(e.getMessage());
		} 
		catch (IOException e) 
		{
			throw new CustomException(e.getMessage());
		}
		finally 
		{
			try 
			{
				bf.close();
			} catch (IOException e) {}
		}
		return json;
	}
	public String getAccessToken(String client_id,String client_secret,String code,String grant_type,String redirect_uri) throws CustomException
	{
		String url = "https://accounts.zoho.com/oauth/v2/token?"
				+ "client_id="+client_id
				+ "&client_secret="+client_secret
				+ "&code="+code
				+ "&grant_type="+grant_type
				+ "&redirect_uri="+redirect_uri;
		JSONObject json = requestUrl(url,null,"POST");
		if(json != null)
		{
			return json.getString("access_token");
		}
		return null;
	}
	public JSONObject getInfo(String url,String client_id,String client_secret,String code,String grant_type,String redirect_uri) throws CustomException
	{
		 String accessToken = getAccessToken(client_id,client_secret,code,grant_type,redirect_uri);
		 return requestUrl(url,accessToken,"GET");
	}
}
