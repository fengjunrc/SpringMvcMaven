package com.test.threadpool;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {
	
	// 线程池中默认线程数为5
	private static int worker_num=5;
	// 工作线程  
   // private WorkThread[] workThrads;  
    // 未处理的任务
    private static volatile int finished_task=0;
    // 任务队列，作为一个缓冲，list 线程不安全        LinkedList 插入删除快
    private List<Runnable> taskQueue = new LinkedList<Runnable>(); 
    
    private static ThreadPool threadPool ;
    
    private ThreadPool(){
    	this(5);
    }
    
    
    private ThreadPool(int work_num){
    	ThreadPool.worker_num= work_num;
    	//workThrads = new WorkThread[work_num];
    	//for (int i = 0; i < worker_num; i++) {  
        //    workThrads[i] = new WorkThread();  
        //    workThrads[i].start();// 开启线程池中的线程  
       // }  
    }
    
}
