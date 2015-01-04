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
	String message="�ϴ��ļ��ɹ�";
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
		//�������ϴ���ͼƬ�ļ�
	     if(p.getContentType().contains("image")){
			ApplicationPart ap=(ApplicationPart) p;
			String name=ap.getFilename();   //��ȡ�ϴ��ļ�������
			
			int path1=name.lastIndexOf("\\")+1;   //���ϴ��ļ�����ȡ
			
			String fname=name.substring(path1,name.length());
			
			book_picture=fileDirString+fname;
			p.write(book_picture);
			
			UpBook file=new UpBook();  //����UpFile����
			file.setBook_name(book_name);
			file.setBook_money(book_money);
		    file.setBook_picture(book_picture);
			file.setBook_page(book_page);
			file.setBook_uptime(book_uptime);
			
			GetTime gettime=new GetTime();
			file.setBook_uptime(gettime.currentlyTime());
			
			BookUtil bookUtil=new BookUtil();
			bookUtil.insertFile(file);   //���
		
			message="�ϴ��ɹ�";
			request.setAttribute("result",message);           //����ʾ��Ϣ������request������
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //������Ӧ�ķ��ص�ַ
			
			requestDispatcher.forward(request, response);
			
		}
		
		
		else{
			 message="���ϴ�ͼƬ";
			request.setAttribute("result",message);           //����ʾ��Ϣ������request������
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //������Ӧ�ķ��ص�ַ
			
			requestDispatcher.forward(request, response);
			
		}
		
		
		
		
		
		
		
	}

}
