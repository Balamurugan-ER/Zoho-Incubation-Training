/**
 * 
 */
package com.bm.framework.regex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.bm.util.*;
/**
 * @author Balamurugan
 *
 */
public class RegularExpressions 
{
	private static Logger logger = Logger.getLogger(RegularExpressions.class.getName());
	// Mobile Number Validator
	public static boolean mobileNumberValidator(String phNumber) throws CustomException
	{
		Utilities.VALID.isNull(phNumber);
		String mobilePattern = "^[7-9][0-9]{9}";
		return Pattern.matches(mobilePattern, phNumber);
	}
	// Alpha numeric strings alone
	// Not Completed
	public static boolean alphaNumericValidator(String alphaNumericChars) throws CustomException
	{
		Utilities.VALID.isNull(alphaNumericChars);
		String alphaNumPattern = "[a-zA-Z0-9]*";
		return Pattern.matches(alphaNumPattern, alphaNumericChars);
	}
	public static boolean stringStarts(String givenString,String matchString) throws CustomException
	{
		Utilities.VALID.isNull(givenString);
		String startsWith = "^"+matchString+".+$";
		return Pattern.matches(startsWith, givenString);
	}
	public static boolean stringContains(String givenString,String matchString) throws CustomException
	{
		Utilities.VALID.isNull(givenString);
		String contains = "^.+"+matchString+".+$";
		return Pattern.matches(contains, givenString);
	}
	public static boolean stringEndsWith(String givenString,String matchString) throws CustomException
	{
		Utilities.VALID.isNull(givenString);
		String endsWith = "^.+"+matchString+"$";
		return Pattern.matches(endsWith, givenString);
	}
	public static boolean stringExactMatch(String givenString,String matchString) throws CustomException
	{
		Utilities.VALID.isNull(givenString);
		String endsWith = matchString;
		return Pattern.matches(endsWith, givenString);
	}
	public static Matcher stringExactMatch(String givenString,String matchString,int flag) throws CustomException
	{
		Utilities.VALID.isNull(givenString);
		String endsWith = matchString;
		Pattern pattern = Pattern.compile(endsWith, flag);
		//Matcher matcher = pattern.matcher(givenString);
		return pattern.matcher(givenString);
	}
	//email validator
	public static boolean emailValidator(String email) throws CustomException
	{
		Utilities.VALID.isNull(email);
		String emailPattern = "^[a-zA-Z0-9]*@{1}[a-zA-Z0-9]*\\.{1}[a-zA-Z0-9]*";
		return Pattern.matches(emailPattern, email);
	}
	public static boolean stringCountRange(String givenString,int range) throws CustomException
	{
		Utilities.VALID.isNull(givenString);
		String mobilePattern = ".{1,"+range+"}";
		return Pattern.matches(mobilePattern,givenString);
	}
	public static Matcher tagfinder(String htmlLines) throws CustomException
	{
		Utilities.VALID.isNull(htmlLines);
		String tagPattern = "</*[a-zA-Z0-9]*>";
		Pattern pattern = Pattern.compile(tagPattern);
		Matcher matcher = pattern.matcher(htmlLines);
		return matcher;
	}
	public static Map matchFinder(List<String> list1,List<String> list2) throws CustomException
	{
		Map<String,Integer> map = new HashMap<>();
		int length = list2.size();
		for(int i = 0;i< length;i++)
		{
			for(String pattern : list1)
			{
				Pattern matchPattern = Pattern.compile(list2.get(i));
				Matcher matcher = matchPattern.matcher(pattern);
				if(matcher.find())
				{
					String matchedStr = matcher.group();
					map.put(matchedStr, list1.indexOf(matchedStr));
				}
			}
		}
		return map;
	}
}
