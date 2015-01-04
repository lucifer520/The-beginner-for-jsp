<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import = "com.news.dao.NewFileDao,com.news.option.News" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= gb2312">
<title>Delete News</title>
</head>
<body>
<% 	String path=request.getParameter("id");
	NewFileDao nf=new NewFileDao();
	try{
		nf.deleteNews(path);
		out.println("Succeed in deleting new news");
	}catch(Exception e){
		e.printStackTrace();
	}finally{
	%>
	<a href="NewsIndex.jsp">back</a>
	<%
	}
	 %>
</body>
</html>