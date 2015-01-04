<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="ISO-8859-1"%>
<%@ page import = "com.news.dao.NewFileDao,com.news.option.News" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>NEWS</title>
</head>
<body>
<%
	String path =request.getParameter("id");
    News n = new News();
	NewFileDao fd = new NewFileDao();
	n=fd.getNew(path);
%>
	<h3 align="center"><%=n.getTitle()%></h3>
	<table align="center">
	<tr>
		<td align="left"><%=n.getNewTime()%></td>
		<td align="right"><%=n.getAuthor()%></td>
	</tr>
	</table>
	<p>&nbsp&nbsp<%=n.getContent()%></p>
	<p align="right"><a href="NewsIndex.jsp">back</a></p>
</body>
</html>