

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
		String path=request.getParameter("path");     //��ȡ�ϴ��ļ�·��
		path=new String(path.getBytes("ISO-8859-1"),"utf-8");
		
		File file=new File(path);                 //����·�������ļ�����
		InputStream in=new FileInputStream(file);         //��ȡ�ļ�������
		OutputStream out=response.getOutputStream();           //�����ļ������
		response.addHeader("Content-Disposition", "attachment;filename="+new String(file.getName().getBytes("utf-8"),"ISO-8859-1"));
		response.addHeader("Content-Length", file.length()+"");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/octet-stream");
		
		
	
		int data=0;
		while((data=in.read())!=-1){ //ѭ�������ļ������ƴ���
			out.write(data);
		}
		
		out.close();
		in.close();
		
	
		
	}

}
