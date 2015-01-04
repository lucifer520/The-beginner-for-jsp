<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UploadServlet" method="post"  name="file" id="file" enctype="mulipart/form-data" onsubmit="return validate()">
  
  
  <ul>
       <li> 请选选择上传文件：</li>
       <li> 上传文件:   <input type="file" name="upfile" /></li>
       
       <li><input type="submit" name="submit" value="上传"/> <input type="reset" name="reset" value="重置"/></li>
  
  </ul>
  
  <%
  
  if(request.getAttribute("result")!=null){
	  out.println("<script> alert('"+request.getAttribute("result")+"');</script>");
  }
  
  
  
  
  %>







</form>

</body>
</html>