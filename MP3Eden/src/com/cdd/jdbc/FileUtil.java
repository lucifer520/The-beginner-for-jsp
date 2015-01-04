package com.cdd.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.cdd.bean.UpFile;

public class FileUtil {
	
	//锟较达拷锟侥硷拷

	public void insertFile(UpFile file){
		String sql="insert into tb_file values"+"(?,?,?,?,?,?)";
	
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //锟斤拷锟斤拷锟斤拷菘锟�
		PreparedStatement preparedStatement;
		try {
			
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1,null);
			preparedStatement.setString(2,file.getFile_name());
			preparedStatement.setString(3, file.getFile_uploadPerson());
			preparedStatement.setString(4, file.getFile_address());
			preparedStatement.setString(5, file.getFile_uptime());
			preparedStatement.setString(6,file.getFile_downPerson());
			
			preparedStatement.executeUpdate();      //执锟斤拷SQL锟斤拷锟�
		
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	
	public ArrayList<UpFile> questFile(){
		String sql="select * from tb_file";
		ArrayList<UpFile> files=new ArrayList<UpFile>();
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //锟斤拷锟斤拷锟斤拷菘锟�
		ResultSet rs;
		
		try {
			Statement stam=conn.createStatement();     // 实锟斤拷statement锟斤拷锟斤拷
			rs=stam.executeQuery(sql);                //实锟斤拷ResultSet锟斤拷锟斤拷
			while(rs.next())
			{
				UpFile file=new UpFile();
				file.setId(rs.getInt("id"));
				file.setFile_name(rs.getString("file_name"));
				file.setFile_uploadPerson(rs.getString("file_uploadPerson"));
				file.setFile_address(rs.getString("file_address"));
				file.setFile_uptime(rs.getString("file_uptime"));
				file.setFile_downPerson(rs.getString("file_showname"));
				files.add(file);
			
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return files;
		
		
		
	}
	
	
	
	public ArrayList<UpFile> fuzzySearchFile(String key){
		String sql="select * from tb_file where file_name LIKE '%"+key+"%'";
		ArrayList<UpFile> files=new ArrayList<UpFile>();
		GetConn getConn=new GetConn();
		Connection conn=getConn.getConnection();     //锟斤拷锟斤拷锟斤拷菘锟�
		ResultSet rs;
		
		try {
			Statement stam=conn.createStatement();     // 实锟斤拷statement锟斤拷锟斤拷
			rs=stam.executeQuery(sql);                //实锟斤拷ResultSet锟斤拷锟斤拷
			while(rs.next())
			{
				UpFile file=new UpFile();
				file.setId(rs.getInt("id"));
				file.setFile_name(rs.getString("file_name"));
				file.setFile_uploadPerson(rs.getString("file_uploadPerson"));
				file.setFile_address(rs.getString("file_address"));
				file.setFile_uptime(rs.getString("file_uptime"));
				file.setFile_downPerson(rs.getString("file_showname"));
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
