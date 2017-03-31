package com.test.thread;

public class Run {

	public static void main(String[] args) throws InterruptedException{
		//MyThread myThread = new MyThread();
		//myThread.start();
		Runnable runable = new MyRunnable();
		Thread thread = new Thread(runable);
		System.out.println("1111="+thread.isAlive());
		thread.start();
		System.out.println("2222="+thread.isAlive());
		Thread.sleep(1000);
		System.out.println("3333="+thread.isAlive());
		System.out.println("end");
	}
}
