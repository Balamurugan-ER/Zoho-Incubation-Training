package programming;

public class Fruits 
{
	private String fruitName;
	private int noOfFruits;
	public Fruits()
	{
		super();
	}
	public Fruits(String fruitName,Integer noOfFruits) 
	{
		setFruitName(fruitName);
		setNoOfFruits(noOfFruits);
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public int getNoOfFruits() {
		return noOfFruits;
	}
	public void setNoOfFruits(int noOfFruits) {
		this.noOfFruits = noOfFruits;
	}
	public String toString()
	{
		return getFruitName()+"-"+getNoOfFruits();
	}
	
}
