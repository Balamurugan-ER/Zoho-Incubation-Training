/**
 * 
 */
package com.bm.testrunner;


import com.bm.framework.inheritance.*;
import com.bm.framework.inheritance.Car.Type;
/**
 * @author Balamurugan
 *
 */
public class TestInheritance {

	private void testMod1()
	{
		Swift swiftObj = new Swift();
		swiftObj.setAirBags(3);;
		swiftObj.setColor("Red");
		swiftObj.setModel("Swift-Model-1");
		swiftObj.setSeats(6);
		System.out.println("Model Name    : "+swiftObj.getModel());
		System.out.println("Car Color     : "+swiftObj.getColor());
		System.out.println("No Of Seats   : "+swiftObj.getSeats());
		System.out.println("No Of AirBags : "+swiftObj.getAirBags());
	}
	private void testMod2()
	{
		Scross scrossObj = new Scross();
		scrossObj.setAirBags(4);
		scrossObj.setColor("Black");
		scrossObj.setEngineNumber("1234567889");
		scrossObj.setModel("Scross-Model-1");
		scrossObj.setSeats(8);
		scrossObj.setType(Type.HATCHBACK);
		scrossObj.setYearOfMake(2000);
		System.out.println("Model Name    	  : "+scrossObj.getModel());
		System.out.println("Model Launched At : "+scrossObj.getYearOfMake());
		System.out.println("Car Type          : "+scrossObj.getType());
		System.out.println("Car Engine Number : "+scrossObj.getEngineNumber());
		System.out.println("Car Color         : "+scrossObj.getColor());
		System.out.println("No Of Seats       : "+scrossObj.getSeats());
		System.out.println("No Of AirBags     : "+scrossObj.getAirBags());
	}
	private static void carsWelcome(Car car)
	{
		System.out.println("Car objects are Welcome");
	}
	private void testMod3()
	{
		Swift swiftObj = new Swift();
		System.out.println("Swift Obj Invoking CarsWelcome()");
		TestInheritance.carsWelcome(swiftObj);
		XUV xuvObj = new XUV();
		System.out.println("XUV Obj Invoking CarsWelcome()");
		TestInheritance.carsWelcome(xuvObj);
		Scross scrossObj = new Scross();
		System.out.println("Scross Obj Invoking CarsWelcome()");
		TestInheritance.carsWelcome(scrossObj);
	}
	private static void UpdatedCarsWelcome(Car car)
	{
		Swift swiftObj = new Swift();
		XUV xuvObj = new XUV();
		Scross scrossObj = new Scross();
		//		swiftObj = (Swift)car;
		//		xuvObj = (XUV)car;
		//		scrossObj = (Scross)car;
		if(car.getClass() == swiftObj.getClass())
		{
			System.out.println("Welcome Hatch ");
		}
		if(car.getClass() == xuvObj.getClass())
		{
			System.out.println("Welcome XUV");
		}
		if(car.getClass() == scrossObj.getClass())
		{
			System.out.println("Welcome Sedan");
		}

	}
	private void testMod4()
	{
		Swift swiftObj = new Swift();
		TestInheritance.UpdatedCarsWelcome(swiftObj);
		XUV xuvObj = new XUV();
		TestInheritance.UpdatedCarsWelcome(xuvObj);
		Scross scrossObj = new Scross();
		TestInheritance.UpdatedCarsWelcome(scrossObj);
	}
	private static void SwiftWelcome(Swift swiftObj) 
	{
		System.out.println("Welcome Swift");
	}
	private void testMod5()
	{
		Swift swiftObj = new Swift();
		TestInheritance.SwiftWelcome(swiftObj);
		Car carObj = new Car();
		//TestRunnerCars.SwiftWelcome(carObj);
		XUV xuvObj = new XUV();
		//TestRunnerCars.SwiftWelcome(xuvObj);
		Scross scrossObj = new Scross();
		//TestRunnerCars.SwiftWelcome(scrossObj);
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

