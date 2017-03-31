package com.springboot.controller;

import org.springframework.boot.SpringApplication;

public class SplitTest {

	
	 
	 public static void main(String[] args){
		 String str ="OIL_PROD";
		 String arr[] = str.split("_");
		 String finalStr = arr[0]+".xml";
		 System.out.println(finalStr);
	 }
	 
}
