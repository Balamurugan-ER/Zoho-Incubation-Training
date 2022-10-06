/**
 * 
 */
package com.bm.test.framework.arraylist;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bm.framework.arraylist.BArrayList;
import com.bm.util.CustomException;

/**
 * @author Balamurugan
 */
public class TestCases 
{
	List<String> testList = new ArrayList<>();
	BArrayList barrayList = new BArrayList();
	@Test
	public void givenList_whenFindLength_thenReturnLength()
	{
		testList.add("one");
		testList.add("Two");
		try 
		{
			assertEquals(barrayList.getSize(testList),2);
		}
		catch (CustomException e) 
		{
			e.printStackTrace();
		}
	}
	@Test
	public void givenObj_whenAddtoList_thenReturnVoid() throws CustomException
	{
		String strObj = "Three";
		barrayList.setValue(testList, strObj);
		assertEquals(testList.contains(strObj),true);
	}
	@Test
	public void givenObjInd_whenAddtoList_thenReturnVoid()
	{
		String strObj = "Four";
		try {
			barrayList.setValue(testList, strObj, 0);
			assertEquals(testList.indexOf(strObj),0);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
