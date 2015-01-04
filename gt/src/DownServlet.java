

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownServlet
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public DownServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getParameter("path");     //获取上传文件路径
		path=new String(path.getBytes("ISO-8859-1"),"utf-8");
		
		File file=new File(path);                 //根据路径创建文件对像
		InputStream in=new FileInputStream(file);         //读取文件数据流
		OutputStream out=response.getOutputStream();           //创建文件输出流
		response.addHeader("Content-Disposition", "attachment;filename="+new String(file.getName().getBytes("utf-8"),"ISO-8859-1"));
		response.addHeader("Content-Length", file.length()+"");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/octet-stream");
		
		
	
		int data=0;
		while((data=in.read())!=-1){ //循环读出文件二进制代码
			out.write(data);
		}
		
		out.close();
		in.close();
		
	
		
	}

}
