<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="UploadServlet"   enctype="multipart/form-data" method="post">
<center>
上传文件名：   <input type="text" name="fileName"  id="fileName" size="20"/>
<br>
选择文件：       <input type="file" name="file" id="file"/>
<br>
<input type="submit" name="upload" value="上传"/>
<input type="reset"  name="reset" value="重新填写"/>
</center>
<%
	
  if(request.getAttribute("result")!=null){
	  
	 
			  out.println("<script> alert('"+request.getAttribute("result")+"');</script>");
		  }

%>

</form>



</body>
</html>