<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import = "com.news.dao.NewFileDao,com.news.option.News" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset= gb2312">
<title>Insert title here</title>
</head>
<body>
<% 	String title=request.getParameter("newstitle");
	String time=request.getParameter("newstime");
	String author=request.getParameter("newsauthor");
	String content=request.getParameter("newscontent");
	NewFileDao nf=new NewFileDao();
	String dirpath="F:\\apache-tomcat-6.0.39\\webapps\\test\\news";
	try{
		nf.inputNews(dirpath,title,time,author,content);
		out.println("Succeed in creating new news");
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