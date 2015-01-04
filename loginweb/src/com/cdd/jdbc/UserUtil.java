package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cdd.bean.User;



public class UserUtil {

	//ʵ��ϵͳ��¼
	public User findUser(User user){
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //������ݿ�
	
	String sql="select *from t_user where user_name=?"+"and user_password=?";               //������ݿ���ӵ�SQL���
	PreparedStatement statement;
	
	User newuser=new User();
	
	try {
		statement=conn.prepareStatement(sql);          //ʵ��Preparedstatement
		statement.setString(1, user.getUser_name());
		statement.setString(2, user.getUser_password());
		
		ResultSet rest=statement.executeQuery();      //ִ��SQL����
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
	
	
	//�û�ע��
	public boolean insertUser(User user){
		String sql="insert into t_user values(?,?,?,?,?,?,?)";
		PreparedStatement statement;
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //������ݿ�
		
		
		try {
			statement=conn.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, user.getUser_name());
			statement.setString(3, user.getUser_password());
			statement.setString(4, user.getUser_email());
			statement.setString(5, user.getUser_sex());
			statement.setString(6, user.getUser_phone());
			statement.setString(7, user.getUser_QQ());
			statement.executeUpdate();                         //ִ��SQL���
			conn.close();
			return true;
		} catch (SQLException e) {
		
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	//�û�Ψһ�Բ�ѯ
	public User findUserName(String name){
		String sql="select * from t_user where user_name='"+name+"'";
		Statement state;
		
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //������ݿ�
		
		
		try {
			
			User user=new User();
			state=conn.createStatement();
			ResultSet rest=state.executeQuery(sql);    //ִ��SQL���
			while(rest.next()){
				user.setId(rest.getInt(1));
			}
			conn.close();
			return user;                             //���ز�ѯ�����û���Ϣ
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
			
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
