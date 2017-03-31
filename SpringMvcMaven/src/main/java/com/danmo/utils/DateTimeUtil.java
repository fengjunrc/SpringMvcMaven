package com.danmo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {

	// 2012-01-01
	public static String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date).toString();
	}

	// 2012-01-01 12:03:03
	public static String getSystemDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date).toString();
	}

	
	// 2012-01-01 12:03:03
	public static String getSystemDateTime1() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date).toString();
	}
	
	// 12：03：04
	public static String getSystemTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date).toString();

	}

	/**
	 * 　　
	 *  获取当前年
	 *   "yyyy"格式
	 */
	public static String getYearTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		return formatter.format(new Date());
	}

	/**
	 * 　　
	 *  获取当前月度字符串。
	 *  日期字符串格式： MM 　　
	 *	其中：  MM
	 *  表示4位年。 　　
	 *  @return
	 * String "yyyy"格式的当前月度字符串。 　　
	 */
	public static String getNowMonth() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		return formatter.format(new Date());
	}

	public static void main(String ars[]) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println("-----------------------");
		System.out.println(sdf.format(date).toString());
		System.out.println("-----------------------");

	}
}
