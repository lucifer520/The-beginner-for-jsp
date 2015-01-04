package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GetConn {

	
	public Connection conn=null;
	static String driver;               //数据库驱动
	static String url;                 //数据库url
	static String user="root";        //用户名
	static String password="123456";   //密码
	public Connection getConnection(){  
			driver="com.mysql.jdbc.Driver";
			url="jdbc:mysql://localhost:3306/db_database20";
			
			try {
				Class.forName(driver);                     //加载数据库驱动
				conn=DriverManager.getConnection(url,user,password);          //连接数据库
				
		
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}                  
		
		
		
		
		return conn;
		
	}
}
