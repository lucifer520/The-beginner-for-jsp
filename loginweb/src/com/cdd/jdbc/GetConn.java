package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GetConn {

	
	public Connection conn=null;
	static String driver;               //��ݿ���
	static String url;                 //��ݿ�url
	static String user="root";        //�û���
	static String password="123456";   //����
	public Connection getConnection(){  
			driver="com.mysql.jdbc.Driver";
			url="jdbc:mysql://localhost:3306/test";
			
			try {
				Class.forName(driver);                     //������ݿ���
				conn=DriverManager.getConnection(url,user,password);          //������ݿ�
				
		
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}                  
		
		
		
		
		return conn;
		
	}
}
