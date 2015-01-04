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
	String message="上传文件成功";
	String fileAddress="";         //定义文件上传地址
	String fileDirString="D:\\eclisp\\MP3Eden\\WebContent\\content\\songs\\";
	String uploadPerson="";          //文件上传人
	String showname="";             //歌曲名
	
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
		HttpSession se = request.getSession();                            // Servlet 中获取 Session 对象
		uploadPerson=(String)se.getAttribute("uses");
		fileName=new String(fileName.getBytes("ISO_8859-1"),"utf-8");
		//仅处理上传的图片文件
		//if(p.getContentType().contains("mp3")){
			ApplicationPart ap=(ApplicationPart) p;
			String name=ap.getFilename();   //获取上传文件的名字
			
			if(name.endsWith("mp3")){
			int path1=name.lastIndexOf("\\")+1;   //对上传文件名截取
			
			String fname=name.substring(path1,name.length());
			
			String names=name.substring(path1,fname.length()-".mp3".length());
			
			fileAddress=fileDirString+fname;
			p.write(fileAddress);
			UpFile upFile=new UpFile();  //创建UpFile对像
			upFile.setFile_name(fileName);
			upFile.setFile_uploadPerson(uploadPerson);
			upFile.setFile_address(fileAddress);
			upFile.setFile_downPerson(names);
			
			GetTime gettime=new GetTime();
			upFile.setFile_uptime(gettime.currentlyTime());
			
			FileUtil fileUtil=new FileUtil();
			fileUtil.insertFile(upFile);   //添加
		
			message="歌曲上传成功";
			request.setAttribute("result",message);           //将提示信息保存在request对像中
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //设置相应的返回地址
			
			requestDispatcher.forward(request, response);
			
		}else if(name.endsWith("lrc"))
				{
                        int path1=name.lastIndexOf("\\")+1;   //对上传文件名截取
			
			          String fname=name.substring(path1,name.length());
			
			            fileAddress=fileDirString+fname;
			            p.write(fileAddress);
			            
			            
			            message="歌词上传成功";
						request.setAttribute("result",message);           //将提示信息保存在request对像中
						
						RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //设置相应的返回地址
						
						requestDispatcher.forward(request, response);
			            
				}
		
		
		else{
			 message="请上传mp3歌曲歌词";
			request.setAttribute("result",message);           //将提示信息保存在request对像中
			
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("fileUpload.jsp"); //设置相应的返回地址
			
			requestDispatcher.forward(request, response);
			
		}
		
		
		
		
		
		
		
	}

}
