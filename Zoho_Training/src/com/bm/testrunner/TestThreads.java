package com.bm.testrunner;

import java.util.Scanner;

import com.bm.framework.threads.ExtendedThread;
import com.bm.framework.threads.RunnableThread;

public class TestThreads 
{
	public static void main(String [] args)
	{
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("1.Create Thread ExtendedThread");
		System.out.println("2.Create thread implementing Runnable interface");
		System.out.println("3.Create Two Threads and display current info");
		System.out.println("4.Threads Sleeping for given seconds ");
		System.out.println("0.Exit");
		while(flag)
		{
			System.out.println("Enter Choice : ");
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
				ExtendedThread threadOne = new ExtendedThread("one");
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
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),"Two");
				threadRun.displayThreadInfo(threadRun);
				threadRun.start();
				threadRun.displayThreadInfo(threadRun);
				threadRun.stop();
				threadRun.displayThreadInfo(threadRun);
				break;
			}
			case 3:
			{
				ExtendedThread threadExt = new ExtendedThread("ExtendedThread");
//				RunnableThread runnableObj = new RunnableThread();
//				Thread threadRun = new Thread(runnableObj,"RunnableThread");
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),"ExtendedThread");
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
				ExtendedThread threadExt = new ExtendedThread("ExtendedThread");
				ExtendedThread threadRun = new ExtendedThread(new RunnableThread(),"RunnableThread");
				threadExt.setMilliSeconds(60000);
				threadRun.setMilliSeconds(45000);
				threadExt.displayThreadInfo(threadExt);
				threadExt.start();
				threadExt.displayThreadInfo(threadExt);
				threadRun.displayThreadInfo(threadRun);
				threadRun.start();
				threadRun.displayThreadInfo(threadRun);
			}
			case 5:
			{
				//ExtendedThread threadExt = new ExtendedThread("ExtendedThread");
				
			}
			}
		}
		scan.close();
	}
}