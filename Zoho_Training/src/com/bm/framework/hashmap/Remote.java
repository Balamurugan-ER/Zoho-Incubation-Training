/**
 * 
 */
package com.bm.framework.hashmap;

/**
 * @author Balamurugan
 *
 */
public class Remote {
	public Remote(String noOfButtons)
	{
		setNoButtons(noOfButtons);
	}
	private String noOfButtons;
	public void setNoButtons(String noOfButtons)
	{
		this.noOfButtons = noOfButtons;
	}
	public String getNoButtons()
	{
		return this.noOfButtons;
	}
	public String toString()
	{
		return noOfButtons;
	}
}
