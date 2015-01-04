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

//�û�ע�ᣬ�û���ѯ�Ƿ��Ѿ�ע��
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
		String message="ע��";
		//String message=request.getParameter("Submit");             //��ȡ�ύ��ť��ֵ
		UserUtil userUtil=new UserUtil();          //�����������û��������������
		
		if(message.equals("ע��")){
			String findname=request.getParameter("username");
			User users=userUtil.findUserName(findname);        //��ȡ�û�ע������
			String mess="�û�������ʹ��";
						if(users.getId()>0){
							mess="�û���������ʹ��";
							request.setAttribute("message",mess);          //����ʾ��Ϣ������request������
							return;
							
						}
			
						if(request.getParameter("password").equals(request.getParameter("repassword"))){
		
						
						User user=new User();                     //�����û�����
					    user.setUser_name(new String(request.getParameter("username").getBytes("iso8859_1"),"utf-8"));
					    user.setUser_password(request.getParameter("password"));
					    
					    user.setUser_sex(new String(request.getParameter("sex").getBytes("iso8859_1"),"utf-8"));
					    user.setUser_email(request.getParameter("email"));
					    user.setUser_phone(request.getParameter("phoneNumber"));
					    boolean r=userUtil.insertUser(user);
					          if(r){
					    	          request.setAttribute("message", "ע��ɹ�");
					                }else{
					                          request.setAttribute("message", "ע��ʧ��");
					                     }
					    
					    
						}else{
							request.setAttribute("message", "�û����벻һ��");
							
							
							
						
						}
		
		
	    
		}else if(message.equals("�û�����֤")){
			User user=userUtil.findUserName(request.getParameter("username"));
			String mess="�û�������ʹ��";
			if(user.getId()>0){
				mess="�û���������ʹ��";
				
			}
	    	request.setAttribute("message", mess);
	    	
	    	
	    }
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Registration.jsp");   
		
		requestDispatcher.forward(request, response);
	    

	}

}
