package com.test.thread;

public class MyThread  extends Thread{
	 
	public void run(){
		//super.run();
		//System.out.println("myThread");
		try {
			for (int i = 0; i < 10; i++) {
				int time = (int)Math.random()*10000;
				Thread.sleep(time);
				System.out.println("name="+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
