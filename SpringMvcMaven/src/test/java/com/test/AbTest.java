package com.test;

public class AbTest {

	public static void main(String[] args){
		int a=10;
		int b=10;
		method1(a,b);
		System.out.println("a="+a);
		System.out.println("b="+b);
	}
	
	
	static void method1(int a, int b){
		System.out.println("a=100");
	    System.out.println("b=200");
		System.exit(0);
	}
}
