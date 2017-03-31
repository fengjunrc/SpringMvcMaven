package com.springboot.controller;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CacheThreadPool();
		FixThread();
	}

	
	public static void CacheThreadPool(){
		ExecutorService cachedThreadPool =  Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index= i;
			try {
				Thread.sleep(index*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(index);
				}
			});
		}
	}
	
	
	public static void FixThread(){
		Executor fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index= i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					System.out.println(index);
					try {
						Thread.sleep(index*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	
	public static void newScheduledThread(){
		ScheduledExecutorService   newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		newScheduledThreadPool.schedule(new Runnable() {
			
			@Override
		public void run() {
				// TODO Auto-generated method stub
				System.out.println("delay 3 seconds");  
			}
		}, 3, TimeUnit.SECONDS);
		
	}
}
