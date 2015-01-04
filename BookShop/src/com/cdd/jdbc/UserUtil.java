package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cdd.bean.User;



public class UserUtil {

	//实现系统登录
	public User findUser(User user){
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //连接数据库
	
	String sql="select *from user where user_name=?"+"and user_password=?";               //定义数据库添加的SQL语句
	PreparedStatement statement;
	
	User newuser=new User();
	
	try {
		statement=conn.prepareStatement(sql);          //实例化Preparedstatement
		statement.setString(1, user.getUser_name());
		statement.setString(2, user.getUser_password());
		
		ResultSet rest=statement.executeQuery();      //执行SQL代码
		while(rest.next()){
			
			newuser.setId(rest.getInt(1));
			
		}
		conn.close();
		return newuser;
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	}
	

	
	}
	
	
	//用户注册
	public boolean insertUser(User user){
		String sql="insert into user values(?,?,?,?,?,?)";
		PreparedStatement statement;
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //连接数据库
		
		
		try {
			statement=conn.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, user.getUser_name());
			statement.setString(3, user.getUser_password());
			statement.setString(4, user.getUser_email());
			statement.setString(5, user.getUser_phone());
			statement.setString(6, user.getUser_sex());
			statement.executeUpdate();                         //执行SQL语句
			conn.close();
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	//用户唯一性查询
	public User findUserName(String name){
		String sql="select * from user where user_name='"+name+"'";
		Statement state;
		
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //连接数据库
		
		
		try {
			
			User user=new User();
			state=conn.createStatement();
			ResultSet rest=state.executeQuery(sql);    //执行SQL语句
			while(rest.next()){
				user.setId(rest.getInt(1));
			}
			conn.close();
			return user;                             //返回查询到的用户信息
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
