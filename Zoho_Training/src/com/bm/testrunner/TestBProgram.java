package com.bm.testrunner;
import com.bm.framework.bprogram.*;
import com.bm.util.CustomException;
import java.util.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
public class TestBProgram {
	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter your choice");
			System.out.println("1.Writing content in files");
			System.out.println("2.Storing properties");
			System.out.println("3.Finding properties value for the key");
			System.out.println("4.Calling custom constructor and print object");
			System.out.println("5.POJO class calling custom constructor");
			System.out.println("6.POJO class calling default constructor & getter , setter methods");
			System.out.println("7.Reflection - Invoking POJO class default constructor and custom constructor");
			System.out.println("8.Enum with values");
			System.out.println("9.Singleton class");
			System.out.println("0.Exit");
			int n = Integer.parseInt(scan.nextLine());
			switch (n)
			{
			case 0:
			{
				flag= false;
				break;
			}
			case 1:
			{
				System.out.println("Enter filename to write");
				String fileName = scan.nextLine();
				try {
					ProgrammingBasic.writeFile(fileName,"/home/inc5/myDir/");
					
				} catch (CustomException e) 
				{
					e.printStackTrace();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				break;
			}
			case 2:
			{	//create properties with five properties
				System.out.println("Enter properties name .txt or .properties");
				String fileName = scan.nextLine();
				int limit = 5;
				System.out.println("Provide five pair of keys and values");
				for(int i=1;i<=limit;i++)
				{
					
					System.out.println("Enter Key :- "+i);
					String key = scan.nextLine();
					System.out.println("Enter Value :- "+i);
					String value = scan.nextLine();
					try {
						PropClass.addEntry(fileName, key, value);
					} catch (CustomException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			case 3:
			{
				//get properties using propname,key 
				System.out.println("Enter properties file name to search props :- ");
				String fileName = scan.nextLine();
				System.out.println("Enter properties key to find value of the property :- ");
				String key = scan.nextLine();
				String value = PropClass.getPropsValue(fileName, key);
				System.out.println(key +" - " +value);
				break;
			}
			case 4:
			{	//to override tostring()
				System.out.println("Enter String to invoke custom constructor :- ");
				String jasmineVariable = scan.nextLine();
				Jasmine jasmine = new Jasmine(jasmineVariable);
				System.out.println(jasmine);
				break;
			}
			case 5:
			{
				//pojo with toString() --> using custom constructor
				Fruits fruit = new Fruits("Apple",10);
				System.out.println(fruit);
				break;
			}
			case 6:
			{
				//pojo --> using default constructor
				Fruits fruit = new Fruits();
				fruit.setFruitName("WaterMelon");
				fruit.setNoOfFruits(10);
				System.out.println(fruit);
				break;
			}
			case 7:
			{
				// reflection a constructor
				// reflection a custom constructor
				try {
					Class refClass = Class.forName("programming.Fruits");
					Fruits t = (Fruits) refClass.newInstance();
					Constructor<?> construct = refClass.getDeclaredConstructor(String.class,Integer.class);
					System.out.println("Enter fruit name :- ");
					String fName = scan.nextLine();
					System.out.println("Enter fruit Count name :- ");
					int fCount = Integer.parseInt(scan.nextLine());
					Object obj = (Fruits)construct.newInstance(fName,fCount);
					System.out.println("Printing custom constructor object");
					System.out.println(obj);
					System.out.println("Printing default constructor object");
					t.setFruitName(fName);
					t.setNoOfFruits(fCount);
					System.out.println(t);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					
					e.printStackTrace();
				} catch (SecurityException e) {
					
					e.printStackTrace();
				} 
				break;
			}
			case 8:
			{
				// enum colors and color codes
				BasicColors.Color[] color = BasicColors.Color.values();
				for(int i=0;i<color.length;i++)
				{
					BasicColors.Color currentColor = BasicColors.Color.getElement(i);
					int cvalue = BasicColors.Color.getColorCode(currentColor);
					System.out.println(currentColor+"-"+cvalue);
				}
				break;
			}
			case 9:
			{
				// Even we call multiple time singleton won't create new object.
				//Enum Singleton - Seriableable,Thread-safe,Reflection
				CarSingleton carObj1 = CarSingleton.INSTANCE;
				CarSingleton carObj2 = CarSingleton.INSTANCE;
				System.out.println(carObj1.getPatternName());
				System.out.println(carObj2.getPatternName());
				System.out.println(carObj1 == carObj2);
			}
			}
		}
		scan.close();
	}

}
