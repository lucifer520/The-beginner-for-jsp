package com.lyq.util.CharacterEncodingFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletMy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletMy() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		if(name!=null&&!name.isEmpty()){
			out.print("你好,"+name);
			out.print("<br>欢迎来到我的主页");
			
		}else{
			out.print("请输入你的中文名");
		}
		out.print("<br><a href=index.jsp>返回</a>");
		out.flush();
		out.close();
	}

}
