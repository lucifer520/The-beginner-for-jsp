<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
<body style="background:url('content/images/bg2.jpg') no-repeat;">
<div >

<center><font  size="20">上传 </font>                  </center>


</div>
<div >
<form action="FileUploadServlet"   enctype="multipart/form-data" method="post">

<table align="center"  border="0" width="500">
         <tr> 
              <td align="right"  width="30%"> 上传文件名： </td>
             <td>  <input type="text" name="filename"  id="filename" size="20"/></td>
                                 
          </tr>
        
        <tr>
         <td align="right"  width="30%">     选择文件：： </td>
             <td>  <input type="file" name="file" id="file"/></td>
                                    
         </tr>
         
         
      
          <tr>
                <td colspan="2" align="center" height="40">
                
                  <input type="submit" name="upload" value="上传"/>
                    <input type="reset"  name="reset" value="重新填写"/>
                     <input type="button"  onclick="window.location.href='index.jsp'" value="返回首页">   
                </td>
                
           </tr>
          
      
</table>

        


</form>
</div>


<%
	
  if(request.getAttribute("result")!=null){
	  
	 
			  out.println("<script> alert('"+request.getAttribute("result")+"');</script>");
		  }

%>

</form>

</body>
</html>