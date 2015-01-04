package com.cdd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import com.cdd.bean.UpBook;
import com.cdd.jdbc.BookUtil;
import com.cdd.util.GetTime;


@WebServlet("/FileUploadServlet")
@MultipartConfig(location="d:/temp")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message="上传文件成功";
	String fileDirString="D:\\eclisp\\BookShop\\WebContent\\content\\image\\";
	private String book_name="";
	private String book_money="";
	private String book_picture="";
	private String book_page="";
	private String book_uptime="";
    public FileUploadServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out=response.getWriter();
		Part p=request.getPart("file");
		String fileName=request.getParameter("filename");
		 
		fileName=new String(fileName.getBytes("ISO_8859-1"),"utf-8");
		//仅处理上传的图片文件
	     if(p.getContentType().contains("image")){
			ApplicationPart ap=(ApplicationPart) p;
			String name=ap.getFilename();   //获取上传文件的名字
			
			int path1=name.lastIndexOf("\\")+1;   //对上传文件名截取
			
			String fname=name.substring(path1,name.length());
			
			book_picture=fileDirString+fname;
			p.write(book_picture);
			
			UpBook file=new UpBook();  //创建UpFile对像
			file.setBook_name(book_name);
			file.setBook_money(book_money);
		    file.setBook_picture(book_picture);
			file.setBook_page(book_page);
			file.setBook_uptime(book_uptime);
			
			GetTime gettime=new GetTime();
			file.setBook_uptime(gettime.currentlyTime());
			
			BookUtil bookUtil=new BookUtil();
			bookUtil.insertFile(file);   //添加
		
			message="上传成功";
			request.setAttribute("result",message);           //将提示信息保存在request对像中
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //设置相应的返回地址
			
			requestDispatcher.forward(request, response);
			
		}
		
		
		else{
			 message="请上传图片";
			request.setAttribute("result",message);           //将提示信息保存在request对像中
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //设置相应的返回地址
			
			requestDispatcher.forward(request, response);
			
		}
		
		
		
		
		
		
		
	}

}
