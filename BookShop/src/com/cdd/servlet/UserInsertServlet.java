package com.cdd.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdd.bean.User;
import com.cdd.jdbc.UserUtil;

//用户注册，用户查询是否已经注册
@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserInsertServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="注册";
		//String message=request.getParameter("Submit");             //获取提交按钮表单值
		UserUtil userUtil=new UserUtil();          //创建保存有用户操作方法类对象
		
		if(message.equals("注册")){
			String findname=request.getParameter("username");
			User users=userUtil.findUserName(findname);        //获取用户注册姓名
			String mess="用户名可以使用";
						if(users.getId()>0){
							mess="用户名不可以使用";
							request.setAttribute("message",mess);          //将提示信息保存在request对像中
							return;
							
						}
			
						if(request.getParameter("password").equals(request.getParameter("repassword"))){
		
						
						User user=new User();                     //创建用户对像
					    user.setUser_name(new String(request.getParameter("username").getBytes("iso8859_1"),"utf-8"));
					    user.setUser_password(request.getParameter("password"));
					    
					    user.setUser_sex(new String(request.getParameter("sex").getBytes("iso8859_1"),"utf-8"));
					    user.setUser_email(request.getParameter("email"));
					    user.setUser_phone(request.getParameter("phoneNumber"));
					    boolean r=userUtil.insertUser(user);
					          if(r){
					    	          request.setAttribute("message", "注册成功");
					                }else{
					                          request.setAttribute("message", "注册失败");
					                     }
					    
					    
						}else{
							request.setAttribute("message", "用户密码不一致");
							
							
							
						
						}
		
		
	    
		}else if(message.equals("用户名验证")){
			User user=userUtil.findUserName(request.getParameter("username"));
			String mess="用户名可以使用";
			if(user.getId()>0){
				mess="用户名不可以使用";
				
			}
	    	request.setAttribute("message", mess);
	    	
	    	
	    }
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Registration.jsp");   
		
		requestDispatcher.forward(request, response);
	    

	}

}
