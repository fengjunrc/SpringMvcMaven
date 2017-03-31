package com.test.thread;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread thread = new MyThread();
		thread.setName("myThread");
		thread.start();
		try {
			for (int i = 0; i < 10; i++) {
				int time = (int)Math.random()*10000;
				Thread.sleep(time);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
