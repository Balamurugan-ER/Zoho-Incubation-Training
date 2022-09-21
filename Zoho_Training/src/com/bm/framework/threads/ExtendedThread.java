package com.bm.framework.threads;
import com.bm.util.*;
public class ExtendedThread extends Thread
{
	private long milliSeconds;
	private boolean flag;
	public ExtendedThread(Runnable target,String name)
	{
		super(target,name);
		setFlag(true);
	}
	public ExtendedThread(String name)
	{
		super(name);
		setFlag(true);
	}
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public long getMilliSeconds() {
		return milliSeconds;
	}
	public void setMilliSeconds(long milliSeconds) {
		this.milliSeconds = milliSeconds;
	}
	@Override
	public void run()
	{
		
		int count =0;
		while(getFlag())
		{
			System.out.println("counter : "+count++);
			try
			{
				if(getMilliSeconds() != 0)
				{
					makeSleep(getMilliSeconds());
				}
			} 
			catch (CustomException e) 
			{

				e.printStackTrace();
			}
		}
		
		
	}
	public void makeSleep(long milliseconds) throws CustomException
	{
		try 
		{
			System.out.println("Going to Sleep : "+this.getName());
			sleep(milliseconds);
		}
		catch (InterruptedException e) 
		{

			throw new CustomException("Thread Interrupted ... ");
		}
		finally
		{
			System.out.println("After to Sleeping : "+this.getName());
		}
	}
	public void displayThreadInfo(Thread thread)
	{
		System.out.println("Thread Name 	: "+thread.getName());
		System.out.println("Thread Priority : "+thread.getPriority());
		System.out.println("Thread State 	: "+thread.getState());
	}

}
