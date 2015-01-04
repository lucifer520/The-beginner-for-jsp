


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
		String filepath=request.getRealPath("upload/"); //ָ���ļ�����λ��
		String message="�ļ��ϴ��ɹ�";
		String address="";
		
		if(ServletFileUpload.isMultipartContent(request)){        //�ж��Ƿ��ϴ��ļ�
			DiskFileItemFactory factory=new DiskFileItemFactory();           //����һ����������
			factory.setSizeThreshold(20*1024);                    //�����ڴ�������洢���ֽ���
			factory.setRepository(factory.getRepository());      //���ô����ʱ�ļ���Ŀ¼
			
			ServletFileUpload upload=new ServletFileUpload(factory);    //�����µ��ļ��ϴ����
			
			int size=2*1024*1024;             //ָ���ϴ��ļ��Ĵ�С
			
			List formlists=null;             //���������ϴ��ļ��ļ��϶���
			
			
			try {
				formlists= upload.parseRequest(request);
			} catch (FileUploadException e) {
				
				e.printStackTrace();
			}
			Iterator iter=formlists.iterator();    //�����ϴ��ļ�������
			
			while(iter.hasNext()){
				FileItem formitem=(FileItem)iter.next();       //��ȡÿ���ϴ��ļ�
				if(!formitem.isFormField()){                          //���Բ����ϴ��ļ��ı���
					String name=formitem.getName();                    //��ȡ�ϴ��ļ�������
					if(formitem.getSize()>size){
						message="���ϴ����ļ�̫С����ѡ��������2M���ļ�";
						break;                                          //�˳�����
						
					}
					
				
				
				
				String adjunctsize=new Long(formitem.getSize()).toString();   //��ȡ�ϴ��ļ��Ĵ�С
				
				if((name==null)||(name.equals(""))&&(adjunctsize.equals("0")))    //����ϴ��ļ�Ϊ��
				continue;
				
				
				adjunctname=name.substring(name.lastIndexOf("\\")+1,name.length());
				
				address=filepath+"\\"+adjunctname;             //�����ϴ��ļ��ı����ַ
				
				File saveFile=new File(address);           //�����ļ������ַ�����ļ�
				
				
				try {
					formitem.write(saveFile);				//���ļ�д����
				} catch (Exception e) {
					
					e.printStackTrace();
				}   
			
				}
	
			}	
		}
	
	
	
	request.setAttribute("result",message);           //����ʾ��Ϣ������request������
	
	RequestDispatcher requestDispatcher=request.getRequestDispatcher("NewFile.jsp"); //������Ӧ�ķ��ص�ַ
	
	requestDispatcher.forward(request, response);
	
	
	}
	
}

	

