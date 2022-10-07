/**
 * 
 */
package com.bm.testrunner;

import java.util.Scanner;
import java.util.logging.Level;

import com.bm.framework.json.PlayWithJson;
/**
 * @author Balamurugan
 *
 */
public class TestPlayWithJson 
{
	
	public static void main(String[] args)
	{
		PlayWithJson json = new PlayWithJson();
		try(Scanner scan = new Scanner(System.in);)
		{
			java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TestPlayWithJson.class.getName());
			logger.log(Level.INFO, "Enter name of the Json ");
			String fileName = scan.next();
			logger.log(Level.INFO,"{0}",json.createJson(fileName+".json"));
			logger.log(Level.INFO,"{0}",json.parseJsonFile(fileName+".json"));			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
