package com.servlet.httpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try{
			throw new Exception("数据库连接失败");
			
		}
		catch(Exception e){
			response.sendError(500,e.getMessage());
			
		}*/
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		
		out.print("<p>上下文路经："+request.getContextPath()+"</p>");
		out.print("<p>HTTP请求类型："+request.getMethod()+"</p>");
		out.print("<p>请求参数："+request.getQueryString()+"</p>");
		out.print("<p>请求URI："+request.getRequestURI()+"</p>");
		out.print("<p>请求URL："+request.getRequestURL().toString()+"</p>");
		out.print("<p>请求Servlet路径："+request.getServletPath()+"</p>");
		out.flush();
		out.close();
		
		/*doGet(request,response);*/
		
		
		
	}

}
