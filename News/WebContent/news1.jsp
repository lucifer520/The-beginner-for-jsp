<%@ page language="java" import="java.util.*,java.io.*;" pageEncoding="gb2312"%>
<html>
<head>
<title>新闻列表</title>
</head>
<body style="background-color:#B2DFEE;">
	<center>
	<h3>新闻公告</h3>
<table>
	<tr>
		<td width="400">发布时间</td>
		<td width="400">新闻题目</td>
		<td width="400">作者</td>
		</tr>
<tr>
</tr>
<%
	String title="",date="",author="";
  	File file = new File("D:\\eclisp\\News\\new");
   	File[] subFile = file.listFiles();
   	for (int i = 0; i < subFile.length; i++) {
		String fileName=subFile[i].getName();
    		Scanner s=new Scanner(subFile[i]); 
			if(s.hasNext()){
			title=s.next();     					
			date=s.next();
			author=s.next();}
		%>
		<tr>
			<td  width="400">  <%=date%>  </td>
			<td  width="400"><a href="news2.jsp?id=<%=fileName%>"><%=title%> </a></td>
			<td  width="400">  <%=author%>  </td>
		</tr>
<%
}
%>
</table>
</center>
</body>
</html>