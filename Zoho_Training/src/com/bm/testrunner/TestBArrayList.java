/**
 * 
 */
package com.bm.testrunner;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bm.util.*;
import com.bm.framework.arraylist.BArrayList;
import com.bm.framework.arraylist.Dog;
/**
 * @author Balamurugan
 */
public class TestBArrayList {
	static Scanner scan = new Scanner(System.in);
	BArrayList obj = new BArrayList();
	static Logger logger = Logger.getLogger(TestBArrayList.class.getName());
	private boolean isValidArr(String[] array,int expLength) throws CustomException
	{
		Utilities.INST.isNull(array);
		if(array.length < expLength)
		{
			throw new CustomException("Given Arguments are not Enough to Process");
		}
		return true;
	}
	private void isValidInd(int index,int maxIndex) throws CustomException
	{
		if(index < 0 || index >= maxIndex)
		{
			throw new CustomException("Index Not Valid");
		}
	}
	private void printAlDetails(ArrayList<?> arrayList) throws CustomException
	{
		logger.log(Level.INFO,"ArrayList : "+arrayList);
		logger.log(Level.INFO,"Length : "+obj.getSize(arrayList));
	}
	private void mod1() throws CustomException
	{
		ArrayList<?> arrayList = new ArrayList<>();
		printAlDetails(arrayList);
	}
	private void mod2(String[] args) throws CustomException
	{
		int size=scan.nextInt();
		ArrayList<String> arrayList = new ArrayList<String>();
		logger.log(Level.INFO,"Enter n Strings : ");
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList,args[i]);
		}
		printAlDetails(arrayList);

	}
	private void mod3(String[] args) throws CustomException
	{
		int size= scan.nextInt();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		logger.log(Level.INFO,"Enter n Integers : ");
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList,Integer.parseInt(args[i]));
		}
		printAlDetails(arrayList);
	}
	private void mod4(String[] args) throws CustomException
	{
		int size=scan.nextInt();
		isValidArr(args,size);
		ArrayList<Dog> dogs = new ArrayList<Dog>();	
		obj.setValue(dogs, new Dog(args[0]));
		obj.setValue(dogs, new Dog(args[1]));
		printAlDetails(dogs);
	}
	private void mod5(String[] args) throws CustomException
	{
		ArrayList<?> arrayList = new ArrayList<>();
		int size = scan.nextInt();
		isValidArr(args,size);
		obj.setValue(arrayList, Integer.parseInt(args[0]));
		obj.setValue(arrayList, Integer.parseInt(args[1]));
		obj.setValue(arrayList, args[2]);
		obj.setValue(arrayList, args[3]);
		obj.setValue(arrayList, args[4]);
		obj.setValue(arrayList, new Dog(args[5]));
		obj.setValue(arrayList, new Dog(args[6]));
		printAlDetails(arrayList);
	}
	private void mod6(String[] args) throws CustomException
	{
		ArrayList<?> arrayList = new ArrayList<>();
		int size=scan.nextInt();
		isValidArr(args,size);
		obj.setValue(arrayList, args[0]);
		obj.setValue(arrayList, args[1]);
		obj.setValue(arrayList, args[2]);
		obj.setValue(arrayList, args[3]);
		logger.log(Level.INFO,"Enter the String two Find : ");
		String string = scan.next();
		int index = obj.indexOfObj(arrayList, string,true);	
		logger.log(Level.INFO,"Index : "+index);
		printAlDetails(arrayList);
	}
	private void mod7(String[] args) throws CustomException
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		int size=scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList, args[i]);
		}
		for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext();) 
		{
			Object object = (Object) iterator.next();
			logger.log(Level.INFO,"{0}",object);
		}
	}
	private void mod8(String[] args) throws CustomException
	{
		int size =scan.nextInt();
		ArrayList<?> arrayList = new ArrayList<>();
		isValidArr(args,size);
		obj.setValue(arrayList, args[0]);
		obj.setValue(arrayList, args[1]);
		logger.log(Level.INFO,"Enter the index (0,1) Find String : ");
		int index = scan.nextInt();
		isValidInd(index,size);
		String string = (String)obj.getValue(arrayList, index);	
		logger.log(Level.INFO,string+" : at "+index);
		printAlDetails(arrayList);
	}
	private void mod9(String[] args) throws CustomException
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		int size = scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList, args[i]);
		}
		logger.log(Level.INFO,"Enter String To find in the ArrayList");
		String string = scan.next();
		logger.log(Level.INFO,"Enter Boolean true for Find First Index\n False To Find Last Index");
		boolean first = scan.nextBoolean();
		int index = obj.indexOfObj(arrayList,string,first);
		logger.log(Level.INFO,"{0}",index);
		printAlDetails(arrayList);
	}
	private void mod10(String[] args) throws CustomException
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		int size = scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList, args[i]);
		}
		logger.log(Level.INFO,"Enter Index to add String");
		int index = scan.nextInt();	
		isValidInd(index,size);
		logger.log(Level.INFO,"Enter String To add in the ArrayList");
		String string = scan.next();
		obj.setValue(arrayList, string, index);
		printAlDetails(arrayList);		
	}
	private void mod11(String[] args) throws CustomException
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		int size = scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList, args[i]);
		}
		logger.log(Level.INFO,"Enter First index");
		int fromIndex = scan.nextInt();	
		isValidInd(fromIndex,size);
		logger.log(Level.INFO,"Enter Last index");
		int toIndex = scan.nextInt();	
		isValidInd(toIndex,size);
		List list = obj.createSubList(arrayList, fromIndex, toIndex);
		ArrayList<String> newArrayList = new ArrayList<String>(list);
		logger.log(Level.INFO,"First ArrayList");
		printAlDetails(arrayList);
		logger.log(Level.INFO,"New ArrayList");
		printAlDetails(newArrayList);
	}
	private void mod12(String[] args) throws CustomException
	{
		ArrayList<String> arrayList1 = new ArrayList<String>();
		int limit1 = scan.nextInt();
		int limit2= scan.nextInt();
		int total=limit1+limit2;
		isValidArr(args,total);
		for(int i=0;i< limit1;i++)
		{
			obj.setValue(arrayList1, args[i]);
		}
		ArrayList<String> arrayList2 = new ArrayList<String>();
		for(int i=limit1;i< total;i++)
		{
			obj.setValue(arrayList2, args[i]);
		}
		ArrayList<String> arrayList3 = new ArrayList<String>();
		arrayList3.addAll(arrayList1);
		arrayList3.addAll(arrayList2);
		logger.log(Level.INFO,"First ArrayList");
		printAlDetails(arrayList1);
		logger.log(Level.INFO,"Second ArrayList");
		printAlDetails(arrayList2);
		logger.log(Level.INFO,"Third ArrayList");
		printAlDetails(arrayList3);
	}
	private void mod13(String[] args) throws CustomException
	{
		ArrayList<String> arrayList1 = new ArrayList<String>();
		int limit1 = scan.nextInt();
		int limit2= scan.nextInt();
		int total=limit1+limit2;
		isValidArr(args,total);
		for(int i=0;i< limit1;i++)
		{
			obj.setValue(arrayList1, args[i]);
		}
		ArrayList<String> arrayList2 = new ArrayList<String>();
		for(int i=limit1;i< total;i++)
		{
			obj.setValue(arrayList2, args[i]);
		}
		ArrayList<String> arrayList3 = new ArrayList<String>();
		arrayList3.addAll(arrayList2);
		arrayList3.addAll(arrayList1);
		logger.log(Level.INFO,"First ArrayList");
		printAlDetails(arrayList1);
		logger.log(Level.INFO,"Second ArrayList");
		printAlDetails(arrayList2);
		logger.log(Level.INFO,"Third ArrayList");
		printAlDetails(arrayList3);
	}
	private void mod14(String[] args) throws CustomException
	{
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int size = scan.nextInt();
		isValidArr(args,size);
		boolean index = false;
		for(int i=0;i<size;i++)
		{
			arrayList.add(Integer.parseInt(args[i]));
		}
		printAlDetails(arrayList);
		logger.log(Level.INFO,"Enter True to Delete an index \nEnter False to Delete an element");
		index = scan.nextBoolean();
		logger.log(Level.INFO,"Enter Number/index");
		int number = scan.nextInt();
		if(index)
		{
			isValidInd(number,size);
			arrayList.remove(number);
		}
		else
		{
			arrayList.remove((Object)number);
		}
		printAlDetails(arrayList);
	}
	private void mod15(String[] args) throws CustomException
	{
		ArrayList<Long> arrayList = new ArrayList<Long>();
		int size = scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			arrayList.add(Long.parseLong(args[i]));
		}
		printAlDetails(arrayList);
		logger.log(Level.INFO,"Enter the From & To Index to Delete Values");
		int fromIndex = scan.nextInt();
		int toIndex = scan.nextInt();
		isValidInd(fromIndex,size);
		isValidInd(toIndex,size);
		obj.removeElements(arrayList, fromIndex, toIndex);
		printAlDetails(arrayList);
	}
	private void mod16(String[] args) throws CustomException
	{
		ArrayList<String> arrayList1 = new ArrayList<String>();
		ArrayList<String> arrayList2 = new ArrayList<String>();
		int firstLen = scan.nextInt();
		int secondLen = scan.nextInt();
		int total=firstLen+secondLen;
		isValidArr(args,total);
		logger.log(Level.INFO,"Enter True/false if need to remove presented element or not");
		boolean present = scan.nextBoolean();
		
		for(int i=0;i<firstLen;i++)
		{
			arrayList1.add(args[i]);
		}
		for(int i=firstLen;i<total;i++)
		{
			arrayList2.add(args[i]);
		}
		obj.removeIfPresent(arrayList1, arrayList2,present);
		printAlDetails(arrayList1);
		printAlDetails(arrayList2);
	}
	private void mod17(String[] args) throws CustomException
	{
		ArrayList<Long> arrayList = new ArrayList<Long>();
		int size = scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			arrayList.add(Long.parseLong(args[i]));
		}
		obj.removeAll(arrayList);
		printAlDetails(arrayList);				
	}
	private void mod18(String[] args) throws CustomException
	{
		
		ArrayList<String> arrayList = new ArrayList<String>();
		int size = scan.nextInt();
		isValidArr(args,size);
		for(int i=0;i<size;i++)
		{
			obj.setValue(arrayList, args[i]);
		}
		printAlDetails(arrayList);
		logger.log(Level.INFO,"Enter String to Find in the List");
		String string = scan.next();
		boolean present = obj.isPresent(arrayList, string);
		logger.log(Level.INFO,"{0}",present);
		printAlDetails(arrayList);
		
	}
	public static void main(String[] args) throws CustomException
	{
		TestBArrayList test = new TestBArrayList();
		logger.log(Level.INFO,"Enter Your choice\n"
				+ "1.Create ArrayList and Print Length\n"
				+ "2.Add 5 String Objects & Print it and Length\n"
				+ "3.Add 5 Integer Print Elements and length\n"
				+ "4.Add Customs Objects\n"
				+ "5.Add 2 Integers,3 Strings,2 Cust Objects\n"
				+ "6.Find the index of Strings in ArrayList 4 Elements\n"
				+ "7.Add 5 Strings - Print Using Iterator\n"
				+ "8.String found by index 2 Elements\n"
				+ "9.String to Index Find First/Last\n"
				+ "10.Insert String at Given Index\n"
				+ "11.Create SubList of given Indexes\n"
				+ "12.Create 3rd ArrayList using 1st & 2nd ArrayList\n"
				+ "13.Create 3rd ArrayList using 2nd & 1st ArrayList\n"
				+ "14.Decimal Array List, Delete the Given elements\n"
				+ "15.Long ArrayList deletes elements with range\n"
				+ "16.Two ArrayList deletes first array list with condition\n"
				+ "17.Add 10 Long And removes all\n"
				+ "18.Search a Element in a list\n"
				+ "0.Exit\n"
				+ "1000.Sanity Check");
		try
		{	
			boolean flag = true;
			while(flag)
			{
				int n = scan.nextInt();
				switch(n)
				{
				case 0:
				{
					flag = false;
					break;
				}
				case 1: 
				{
					test.mod1();
					break;
				}
				case 2:
				{
					test.mod2(args);
					break;
				}
				case 3:
				{
					test.mod3(args);
					break;
				}
				case 4:
				{
					test.mod4(args);
					break;
				}
				case 5:
				{
					test.mod5(args);
					break;
				}
				case 6:
				{
					test.mod6(args);
					break;
				}
				case 7:
				{
					test.mod7(args);
					break;
				}
				case 8:
				{
					test.mod8(args);
					break;
				}
				case 9:
				{
					test.mod9(args);
					break;
				}
				case 10:
				{
					test.mod10(args);
					break;
				}
				case 11:
				{
					test.mod11(args);
					break;
				}
				case 12:
				{
					test.mod12(args);
					break;
				}
				case 13:
				{
					test.mod13(args);
					break;
				}
				case 14:
				{
					test.mod14(args);
					break;
				}
				case 15:
				{
					test.mod15(args);
					break;
				}
				case 16:
				{
					test.mod16(args);
					break;
				}
				case 17:
				{
					test.mod17(args);
					break;
				}
				case 18:
				{
					test.mod18(args);
					break;
				}
				case 1000:
				{
					Utilities.INST.check("com.bm.framework.arraylist.BArrayList");
					break;
				}
				}

			}


		}
		catch(CustomException e)
		{
			logger.log(Level.SEVERE,e.getMessage());
			e.printStackTrace();
		}
		catch(InputMismatchException e)
		{
			logger.log(Level.SEVERE,"Invalid input type");
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			logger.log(Level.SEVERE,"String Argument Found Instead of Number");
			e.printStackTrace();
		}
		finally
		{
			scan.close();
		}
	}

}
