package com.cdd.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.cdd.bean.User;
import com.cdd.jdbc.UserUtil;


@WebServlet("/getlogin")
public class getlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getlogin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		UserUtil userUtil=new UserUtil(); 
		User user=new User();
		String name = request.getParameter("name");
		name=new String(name.getBytes("ISO_8859-1"),"utf-8");
		String password = request.getParameter("password");
		user.setUser_name(name);      
		user.setUser_password(password);  
        User use=userUtil.findUser(user);
        JSONObject jObject = new JSONObject();
		if(use.getId()>0){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("user_name", name);
			map.put("user_password", password);
			
			try {
				jObject.put("ret", 0);
				jObject.put("msg", map);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter out = response.getWriter();
			out.println(jObject);
			out.flush();
			out.close();
			
		}else{
			try {
				jObject.put("ret", 1);
				jObject.put("msg", "密码或用户名不存在");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter();
			out.println(jObject);
			out.flush();
			out.close();
		}
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
