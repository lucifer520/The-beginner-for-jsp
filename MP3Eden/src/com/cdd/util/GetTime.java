package com.cdd.util;

import java.text.DateFormat;
import java.util.Date;



public class GetTime {
	
	public String currentlyTime(){
		
		Date date=new Date();                  //�������������
		//��ȡ��ǰ��ݡ��·ݡ����ڡ����ڵ�����
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.FULL);
		return dateFormat.format(date);
		
		
		
	}
	
	
	

}
