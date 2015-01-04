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


//   ��¼Servlet��ȡ�û���Ϣ
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
		
		UserUtil userUtil=new UserUtil();          	 //���������û���֤�����������
		User user=new User();                         //����javaBean��Ķ���
		String name_use=request.getParameter("username");
		String password_use=request.getParameter("password");
		user.setUser_name(name_use);      //��ȡ�û���¼���û�����Ϣ
		user.setUser_password(password_use);  //��ȡ�û���¼���û�������Ϣ
		
		User use=userUtil.findUser(user);                  // ��ѯ�û���Ϣ
		
		if(use.getId()>0){                            //�����ѯ�����û�Id����0
			
			request.getSession().setAttribute("uses",name_use);     //�� ���������û�����������session������
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");    //������Ӧ���ص�ַ
			requestDispatcher.forward(request, response); 
			
			
		}else{
			request.setAttribute("message", "�û��������������");
			RequestDispatcher requestDispather=request.getRequestDispatcher("SignIn.jsp");
			requestDispather.forward(request, response);
			
			
			
		}
		
		
		
		
	}

}
