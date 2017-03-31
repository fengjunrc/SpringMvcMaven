package com.test;

import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("输入年龄");
		int age = s.nextInt();
		String str = "";
		if(age==24){
			str="yes";
		}else{
			str="no";
		}
		System.out.println(str);
	}

}
