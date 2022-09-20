package com.bm.framework.bprogram;

public class CarSingleton {
	private String carBluePrint;

	private CarSingleton(){};
	public static CarSingleton carObj = null;
	public String getCarBluePrint() {
		return carBluePrint;
	}
	public void setCarBluePrint(String carBluePrint) {
		this.carBluePrint = carBluePrint;
	}
	public static CarSingleton getInstance()
	{
		if(carObj == null)
		{
			return carObj = new CarSingleton();
		}
		return carObj;
	}
}
