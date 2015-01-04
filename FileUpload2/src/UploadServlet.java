


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UploadServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adjunctname;
		String filepath=request.getRealPath("upload/"); //指定文件保存位置
		String message="文件上传成功";
		String address="";
		
		if(ServletFileUpload.isMultipartContent(request)){        //判断是否上传文件
			DiskFileItemFactory factory=new DiskFileItemFactory();           //创建一个工厂对像
			factory.setSizeThreshold(20*1024);                    //设置内存中容许存储的字节数
			factory.setRepository(factory.getRepository());      //设置存放临时文件的目录
			
			ServletFileUpload upload=new ServletFileUpload(factory);    //创建新的文件上传句柄
			
			int size=2*1024*1024;             //指定上传文件的大小
			
			List formlists=null;             //创建保存上传文件的集合对像
			
			
			try {
				formlists= upload.parseRequest(request);
			} catch (FileUploadException e) {
				
				e.printStackTrace();
			}
			Iterator iter=formlists.iterator();    //创建上传文件迭代器
			
			while(iter.hasNext()){
				FileItem formitem=(FileItem)iter.next();       //获取每个上传文件
				if(!formitem.isFormField()){                          //忽略不是上传文件的表单域
					String name=formitem.getName();                    //获取上传文件的名称
					if(formitem.getSize()>size){
						message="您上传的文件太小，请选出不超过2M的文件";
						break;                                          //退出程序
						
					}
					
				
				
				
				String adjunctsize=new Long(formitem.getSize()).toString();   //获取上传文件的大小
				
				if((name==null)||(name.equals(""))&&(adjunctsize.equals("0")))    //如果上传文件为空
				continue;
				
				
				adjunctname=name.substring(name.lastIndexOf("\\")+1,name.length());
				
				address=filepath+"\\"+adjunctname;             //创建上传文件的保存地址
				
				File saveFile=new File(address);           //根据文件保存地址创建文件
				
				
				try {
					formitem.write(saveFile);				//向文件写数据
				} catch (Exception e) {
					
					e.printStackTrace();
				}   
			
				}
	
			}	
		}
	
	
	
	request.setAttribute("result",message);           //将提示信息保存在request对像中
	
	RequestDispatcher requestDispatcher=request.getRequestDispatcher("NewFile.jsp"); //设置相应的返回地址
	
	requestDispatcher.forward(request, response);
	
	
	}
	
}

	

