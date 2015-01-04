<%@ page language="java"  contentType="text/html; charset=gb2312"%>
<%@ page import = "com.news.dao.*,com.news.option.News,java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>新闻公告</title>
</head>
<body>
	
<% 	NewFileDao fd = new NewFileDao();
	NewFileDao newDao=new NewFileDao();
		HashMap<String, News> hm =new HashMap<String, News>();
		try{
		hm=newDao.getNewsList("F:\\apache-tomcat-6.0.39\\webapps\\test\\news");
		Iterator iter=hm.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry entry=(Map.Entry)iter.next();
			Object key=entry.getKey();
			Object val=entry.getValue();
			News news=(News)val;
			String time=news.getNewTime();
			String title=news.getTitle();
			String author=news.getAuthor();
			%>
			
			<table>
				<tr>
					<td><%=time %></td>
					<td><a href="NewsShow.jsp?id=<%=news.getFilePath()%>"> <%=title %> </a> </td>
					<td><%=author %></td>
					<td><a href="NewsEdit1.jsp?id=<%=news.getFilePath()%>"> edit </a>
					<td><a href="NewsDelete.jsp?id=<%=news.getFilePath()%>"> delete </a>
			   </td>
			 </table>
			
			<%
		}
		%>
		<a href="NewsCreate1.jsp">增加</a>
		<%
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>