package com.bm.testrunner;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.bm.framework.threads.ExtendedThread;
import com.bm.framework.threads.RunnableThread;

public class TestThreads 
{
	private static Logger logger = Logger.getLogger(TestThreads.class.getName());
	private static void toggleThread(ExtendedThread thread)
	{
		try
		{
			logger.log(Level.INFO,"Sleeping ..M "+thread.getName());
			thread.sleep(30000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			thread.setFlag(false);
			thread.displayThreadInfo(thread);
		}
	}
	public static void main(String [] args)
	{
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		logger.log(Level.INFO,"1.Create Thread ExtendedThread\n"
				+ "2.Create thread implementing Runnable interface\n"
				+ "3.Create Two Threads and display current info\n"
				+ "4.Threads Sleeping for given seconds\n"
				+ "5.Thread dumps\n"
				+ "0.Exit\n"
				+ "Enter Choice : ");
		while(flag)
		{
			int n = scan.nextInt();
			switch(n)
			{
			case 0:
			{
				flag = false;
				break;
			}
			case 1:
			{
				String tName = scan.next();
				ExtendedThread threadOne = new ExtendedThread(tName);
				threadOne.displayThreadInfo(threadOne);
				threadOne.start();
				threadOne.displayThreadInfo(threadOne);
				threadOne.stop();
				threadOne.displayThreadInfo(threadOne);
				break;
			}
			case 2:
			{
//				RunnableThread runThread = new RunnableThread();
//				Thread thread = new Thread(runThread,"two");
				String tName = scan.next();
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),tName);
				threadRun.displayThreadInfo(threadRun);
				threadRun.start();
				threadRun.displayThreadInfo(threadRun);
				threadRun.stop();
				threadRun.displayThreadInfo(threadRun);
				break;
			}
			case 3:
			{
				logger.log(Level.INFO, "Enter Name for Two Threads");
				String t1Name = scan.next();
				String t2Name = scan.next();
				ExtendedThread threadExt = new ExtendedThread(t1Name);
//				RunnableThread runnableObj = new RunnableThread();
//				Thread threadRun = new Thread(runnableObj,"RunnableThread");
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),t2Name);
				threadExt.displayThreadInfo(Thread.currentThread());
				threadExt.start();
				threadExt.displayThreadInfo(Thread.currentThread());
				threadRun.displayThreadInfo(Thread.currentThread());
				threadRun.start();
				threadRun.displayThreadInfo(Thread.currentThread());
				break;
			}
			case 4:
			{
				logger.log(Level.INFO, "Enter Name for Two Threads");
				String t1Name = scan.next();
				String t2Name = scan.next();
				ExtendedThread threadExt = new ExtendedThread(t1Name);
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),t2Name);
				threadExt.setMilliSeconds(60000);
				threadRun.setMilliSeconds(45000);
				threadExt.displayThreadInfo(threadExt);
				threadExt.start();
				threadExt.displayThreadInfo(threadExt);
				threadRun.displayThreadInfo(threadRun);
				threadRun.start();
				threadRun.displayThreadInfo(threadRun);
				break;
			}
			case 5:
			{
				logger.log(Level.INFO, "Enter Name for Two Threads");
				String t1Name = scan.next();
				String t2Name = scan.next();
				ExtendedThread threadExt = new ExtendedThread(t1Name);				
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),t2Name);	
				threadExt.setMilliSeconds(4000);
				threadRun.setMilliSeconds(3000);
				logger.log(Level.INFO,threadExt.getName()+" Started at Main..");
				logger.log(Level.INFO,threadRun.getName()+" Started at Main..");
				threadExt.start();
				threadRun.start();	
				break;
			}
			case 6:
			{
				logger.log(Level.INFO, "Enter Name for Two Threads");
				String t1Name = scan.next();
				String t2Name = scan.next();
				ExtendedThread threadExt = new ExtendedThread(t1Name);				
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),t2Name);	
				threadExt.setMilliSeconds(4000);
				threadRun.setMilliSeconds(3000);
				logger.log(Level.INFO,threadExt.getName()+" Started at Main..");
				logger.log(Level.INFO,threadRun.getName()+" Started at Main..");
				threadExt.start();
				threadRun.start();
				toggleThread(threadExt);
				toggleThread(threadRun);
				break;
			}
			}
		}
		scan.close();
	}
}
