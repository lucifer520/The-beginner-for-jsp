package com.cdd.util;

import java.text.DateFormat;
import java.util.Date;



public class GetTime {
	
	public String currentlyTime(){
		
		Date date=new Date();                  //创建日期类对象
		//获取当前年份、月份、日期、星期等内容
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
		
		
		
	}
	
	
	

}
