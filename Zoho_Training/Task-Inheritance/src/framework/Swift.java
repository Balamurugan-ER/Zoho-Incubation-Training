package framework;
/**
 * @author Balamurugan
 *
 */

public class Swift extends Car{
	private int seats;
	private int airBags;
	private String model;
	private String color;
	public void setSeats(int seats)
	{
		this.seats = seats;
	}
	public void setAirBags(int airBags)
	{
		this.airBags = airBags;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public int getSeats()
	{
		return this.seats;
	}
	public int getAirBags()
	{
		return this.airBags;
	}
	public String getModel()
	{
		return this.model;
	}
	public String getColor()
	{
		return this.color;
	}
}
