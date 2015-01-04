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


//   登录Servlet获取用户信息
@WebServlet("/EnterServlet")
public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EnterServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserUtil userUtil=new UserUtil();          	 //创建保存用户验证方法的类对象
		User user=new User();                         //创建javaBean类的对像
		String name_use=request.getParameter("username");
		String password_use=request.getParameter("password");
		user.setUser_name(name_use);      //获取用户登录的用户名信息
		user.setUser_password(password_use);  //获取用户登录的用户密码信息
		
		User use=userUtil.findUser(user);                  // 查询用户信息
		
		if(use.getId()>0){                            //如果查询出的用户Id大于0
			
			request.getSession().setAttribute("uses",name_use);     //将 检索出的用户名保存子在session对象中
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");    //设置相应返回地址
			requestDispatcher.forward(request, response); 
			
			
		}else{
			request.setAttribute("message", "用户或密码输入错误");
			RequestDispatcher requestDispather=request.getRequestDispatcher("SignIn.jsp");
			requestDispather.forward(request, response);
			
			
			
		}
		
		
		
		
	}

}
