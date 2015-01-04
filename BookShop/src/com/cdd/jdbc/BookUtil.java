package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.cdd.bean.UpBook;

public class BookUtil {
	
	//上传文件

	public void insertFile(UpBook file){
		String sql="insert into books values"+"(?,?,?,?,?,?)";
	
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //连接数据库
		PreparedStatement preparedStatement;
		try {
			
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1,null);
			preparedStatement.setString(2,file.getBook_name());
			preparedStatement.setString(3, file.getBook_money());
			preparedStatement.setString(4, file.getBook_picture());
			preparedStatement.setString(5, file.getBook_page());
			preparedStatement.setString(6,file.getBook_uptime());
			
			preparedStatement.executeUpdate();      //执行SQL语句
		
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	public ArrayList<UpBook> questFile(){
		String sql="select * from books";
		ArrayList<UpBook> files=new ArrayList<UpBook>();
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //连接数据库
		ResultSet rs;
		
		try {
			Statement stam=conn.createStatement();     // 实例化statement对像
			rs=stam.executeQuery(sql);                //实例化ResultSet对像
			while(rs.next())
			{
				UpBook file=new UpBook();
				file.setId(rs.getInt("id"));
				file.setBook_name(rs.getString("book_name"));
				file.setBook_money(rs.getString("book_money"));
				file.setBook_picture(rs.getString("book_picture"));
				file.setBook_page(rs.getString("book_page"));
				file.setBook_uptime(rs.getString("book_uptime"));
				files.add(file);
			
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return files;
		
		
		
	}
	
	
	
	
	

}
