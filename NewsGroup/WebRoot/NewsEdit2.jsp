<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import = "com.news.dao.NewFileDao,com.news.option.News" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>Edit News</title>
  </head>
  <body>
  	<%
  		String title=request.getParameter("newstitle");
  		String time=request.getParameter("newstime");
  		String author=request.getParameter("newsauthor");
  		String content=request.getParameter("newscontent");
  		String dirpath=request.getParameter("newspath");
  		NewFileDao nf= new NewFileDao();
  		if(nf.deleteNews(dirpath)){
  			String filepath="F:\\apache-tomcat-6.0.39\\webapps\\test\\news";
  			nf.inputNews(filepath, title, time, author, content);
  			out.println("Succeed in editing news");
  		}
  	%>
  	<a href="NewsIndex.jsp">back</a>
  </body>
</html>
