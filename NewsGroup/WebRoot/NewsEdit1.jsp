<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import = "com.news.dao.NewFileDao,com.news.option.News" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Edit News</title>
</head>
<body>
<%
	String path=request.getParameter("id");
	News n = new News();
	NewFileDao fd = new NewFileDao();
	n=fd.getNew(path);
	
%>
<form action="NewsEdit2.jsp">
<table>
	<tr><td>新闻标题<input type="text" name="newstitle" value="<%=n.getTitle()%>" maxlength="85"></td></tr>
	<tr><td>发布时间<input type="text" name="newstime" value="<%=n.getNewTime()%>"></td></tr>
	<tr><td>发布人<input type="text" name="newsauthor" value="<%=n.getAuthor()%>"></td></tr>
	<tr><td>新闻内容<textarea rows="30" cols="140" name="newscontent" ><%=n.getContent()%></textarea></td></tr>
	<tr><td><input type="submit" name="submit" value="submit"></td></tr>
	<tr><td><input type="hidden" name="newspath" value="<%=path%>"></td></tr>
</table>
	<a href="NewsIndex.jsp">back</a>
</form>

</body>
</html>