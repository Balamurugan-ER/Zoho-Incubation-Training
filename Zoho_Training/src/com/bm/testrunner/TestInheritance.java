/**
 * 
 */
package com.bm.testrunner;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bm.framework.inheritance.*;
/**
 * @author Balamurugan
 *
 */
public class TestInheritance 
{

	private static Logger logger = Logger.getLogger(TestInheritance.class.getName());
	private static Scanner scan = new Scanner(System.in);
	private void testMod1()
	{
		Swift swiftObj = new Swift();
		logger.log(Level.INFO, "Enter Number of AirBags \nEnter Colour\nEnter Model\nEnter number Of Seats");
		int airBags = scan.nextInt();
		String color = scan.next();
		String model = scan.next();
		int seats = scan.nextInt();
		swiftObj.setAirBags(airBags);
		swiftObj.setColor(color);
		swiftObj.setModel(model);
		swiftObj.setSeats(seats);
		logger.log(Level.INFO,"Model Name    : "+swiftObj.getModel());
		logger.log(Level.INFO,"Car Color     : "+swiftObj.getColor());
		logger.log(Level.INFO,"No Of Seats   : "+swiftObj.getSeats());
		logger.log(Level.INFO,"No Of AirBags : "+swiftObj.getAirBags());
	}
	private void testMod2()
	{
		Scross scrossObj = new Scross();
		logger.log(Level.INFO, "Enter Num of AirBags\nEnter Colour \n Enter Engine Number \n Enter Number of Seats\n"
				+ "Enter option from 1-3 to choose a car type\n"
				+ "\n Enter year of made");
		int airBags = scan.nextInt();
		String color = scan.next();
		String engineNumber = scan.next();
		String model = scan.next();
		int noOfSeats = scan.nextInt();
		int carType = scan.nextInt();
		int year = scan.nextInt();
		scrossObj.setAirBags(airBags);
		scrossObj.setColor(color);
		scrossObj.setEngineNumber(engineNumber);
		scrossObj.setModel(model);
		scrossObj.setSeats(noOfSeats);
		scrossObj.setYearOfMake(year);
		if(carType == 1)
		{
			scrossObj.setType(Car.Type.HATCHBACK);
		}
		if(carType == 2)
		{
			scrossObj.setType(Car.Type.SEDAN);
		}
		else
		{
			scrossObj.setType(Car.Type.SUV);
		}		
		scrossObj.setYearOfMake(2000);
		logger.log(Level.INFO,"Model Name : "+scrossObj.getModel()+"\n"
				+ "Model Launched At : "+scrossObj.getType()+"\n"
				+ "Year of Make : "+scrossObj.getYearOfMake()+"\n"
				+ "Car Type : "+scrossObj.getType()+"\n"
				+ "Car Engine Number : "+scrossObj.getEngineNumber()+"\n"
				+ "Car Color : "+scrossObj.getColor()+"\n"
				+ "No of Seats : "+scrossObj.getSeats()+"\n"
				+ "No Of AirBags : "+scrossObj.getAirBags());
	}
	private static void carsWelcome(Car car)
	{
		logger.log(Level.INFO,"Car objects are Welcome");
	}
	private void testMod3()
	{
		Swift swiftObj = new Swift();
		logger.log(Level.INFO,"Swift Obj Invoking CarsWelcome()");
		TestInheritance.carsWelcome(swiftObj);
		XUV xuvObj = new XUV();
		logger.log(Level.INFO,"XUV Obj Invoking CarsWelcome()");
		TestInheritance.carsWelcome(xuvObj);
		Scross scrossObj = new Scross();
		logger.log(Level.INFO,"Scross Obj Invoking CarsWelcome()");
		TestInheritance.carsWelcome(scrossObj);
	}
	private static void updatedCarsWelcome(Car car)
	{
		Swift swiftObj = new Swift();
		XUV xuvObj = new XUV();
		Scross scrossObj = new Scross();
				swiftObj = (Swift)car;
				xuvObj = (XUV)car;
				scrossObj = (Scross)car;
		if(car.getClass() == swiftObj.getClass())
		{
			logger.log(Level.INFO,"Welcome Hatch ");
		}
		if(car.getClass() == xuvObj.getClass())
		{
			logger.log(Level.INFO,"Welcome XUV");
		}
		if(car.getClass() == scrossObj.getClass())
		{
			logger.log(Level.INFO,"Welcome Sedan");
		}

	}
	private void testMod4()
	{
		Swift swiftObj = new Swift();
		TestInheritance.updatedCarsWelcome(swiftObj);
		XUV xuvObj = new XUV();
		TestInheritance.updatedCarsWelcome(xuvObj);
		Scross scrossObj = new Scross();
		TestInheritance.updatedCarsWelcome(scrossObj);
	}
	private static void swiftWelcome(Swift swiftObj) 
	{
		logger.log(Level.INFO,"Welcome Swift");
	}
	private void testMod5()
	{
		Swift swiftObj = new Swift();
		TestInheritance.swiftWelcome(swiftObj);
//		Car carObj = new Car();
//		TestInheritance.swiftWelcome(carObj);
//		XUV xuvObj = new XUV();
//		TestInheritance.swiftWelcome(xuvObj);
//		Scross scrossObj = new Scross();
//		TestInheritance.swiftWelcome(scrossObj);
	}
	private void testMod6() 
	{
		Scross scrossObj = new Scross();
		scrossObj.maintainance();
		Car carScrossObj = new Scross();
		carScrossObj.maintainance();
		Car car = new Car();
		car.maintainance();
		Swift swiftObj = new Swift();
		swiftObj.maintainance();
		
	}
	private void testMod7()
	{
		XUV xuvObj1 = new XUV();
		XUV xuvObj2 = new XUV();
	}
	private void testMod8()
	{
		//BirdAbstract bird = new BirdAbstract();
		ParrotMod parrot = new ParrotMod();
		parrot.fly();
		parrot.speak();
	}
	private void testMod9()
	{
		Duck duckObj = new Duck();
		duckObj.fly();
		duckObj.speak();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestInheritance obj = new TestInheritance();
		obj.testMod1();
		obj.testMod2();
		obj.testMod3();
		obj.testMod4();
		obj.testMod5();
		obj.testMod6();
		obj.testMod7();
		obj.testMod8();
		obj.testMod9();
	}
}

