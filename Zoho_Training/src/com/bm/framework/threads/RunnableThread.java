package com.bm.framework.threads;

public class RunnableThread implements Runnable
{
	
	public void run()
	{
		System.out.println( "RunnableThread is Running ");
	}
//	public void displayThreadInfo(Thread thread)
//	{
//		System.out.println("Thread Name 	: "+thread.getName());
//		System.out.println("Thread Priority : "+thread.getPriority());
//		System.out.println("Thread State 	: "+thread.getState());
//	}
	
//	public void displayThreadInfo()
//	{
//		System.out.println("Thread Name 	: "+Thread.currentThread().getName());
//		System.out.println("Thread Priority : "+Thread.currentThread().getPriority());
//		System.out.println("Thread State 	: "+Thread.currentThread().getState());
//	}
}
