package framework;
/**
 * @author Balamurugan
 *
 */


public class Car {
	public Car()
	{
		super();
	}
	public Car(String message)
	{
		System.out.println(message);
	}
	private int yearOfMake;
	private String engineNumber;
	public enum Type
	{
		SEDAN,
		HATCHBACK,
		SUV;	
	}
	private Type type;
	public void setYearOfMake(int yearOfMake)
	{
		this.yearOfMake = yearOfMake;
	}
	public void setEngineNumber(String engineNumber)
	{
		this.engineNumber = engineNumber;
	}
	public void setType(Type type)
	{
		this.type = type;
	}
	public int getYearOfMake()
	{
		return this.yearOfMake;
	}
	public String getEngineNumber()
	{
		return this.engineNumber;
	}
	public Type getType()
	{
		return this.type;
	}
	public void maintainance()
	{
		System.out.println("Car Under Maintainance");
	}
}

