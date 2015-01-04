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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import com.cdd.bean.UpFile;
import com.cdd.jdbc.FileUtil;
import com.cdd.util.GetTime;


@WebServlet("/FileUploadServlet")
@MultipartConfig(location="d:/temp")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String message="�ϴ��ļ��ɹ�";
	String fileAddress="";         //�����ļ��ϴ���ַ
	String fileDirString="D:\\eclisp\\MP3Eden\\WebContent\\content\\songs\\";
	String uploadPerson="";          //�ļ��ϴ���
	String showname="";             //������
	
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
		HttpSession se = request.getSession();                            // Servlet �л�ȡ Session ����
		uploadPerson=(String)se.getAttribute("uses");
		fileName=new String(fileName.getBytes("ISO_8859-1"),"utf-8");
		//�������ϴ���ͼƬ�ļ�
		//if(p.getContentType().contains("mp3")){
			ApplicationPart ap=(ApplicationPart) p;
			String name=ap.getFilename();   //��ȡ�ϴ��ļ�������
			
			if(name.endsWith("mp3")){
			int path1=name.lastIndexOf("\\")+1;   //���ϴ��ļ�����ȡ
			
			String fname=name.substring(path1,name.length());
			
			String names=name.substring(path1,fname.length()-".mp3".length());
			
			fileAddress=fileDirString+fname;
			p.write(fileAddress);
			UpFile upFile=new UpFile();  //����UpFile����
			upFile.setFile_name(fileName);
			upFile.setFile_uploadPerson(uploadPerson);
			upFile.setFile_address(fileAddress);
			upFile.setFile_downPerson(names);
			
			GetTime gettime=new GetTime();
			upFile.setFile_uptime(gettime.currentlyTime());
			
			FileUtil fileUtil=new FileUtil();
			fileUtil.insertFile(upFile);   //���
		
			message="�����ϴ��ɹ�";
			request.setAttribute("result",message);           //����ʾ��Ϣ������request������
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //������Ӧ�ķ��ص�ַ
			
			requestDispatcher.forward(request, response);
			
		}else if(name.endsWith("lrc"))
				{
                        int path1=name.lastIndexOf("\\")+1;   //���ϴ��ļ�����ȡ
			
			          String fname=name.substring(path1,name.length());
			
			            fileAddress=fileDirString+fname;
			            p.write(fileAddress);
			            
			            
			            message="����ϴ��ɹ�";
						request.setAttribute("result",message);           //����ʾ��Ϣ������request������
						
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //������Ӧ�ķ��ص�ַ
						
						requestDispatcher.forward(request, response);
			            
				}
		
		
		else{
			 message="���ϴ�mp3�������";
			request.setAttribute("result",message);           //����ʾ��Ϣ������request������
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //������Ӧ�ķ��ص�ַ
			
			requestDispatcher.forward(request, response);
			
		}
		
		
		
		
		
		
		
	}

}
