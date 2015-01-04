<%@ page language="java" import="java.util.*,java.io.*;" pageEncoding="gb2312"%>
<html>
	<head>
		<title></title>
		</head>
<body style="background-color:#B2DFEE;">
<%
	String title="",author="",date="",content="";
	String id=request.getParameter("id");
	File file = new File("D:\\eclisp\\News\\new");
   	File[] subFile = file.listFiles();
	for(int i=0;i<subFile.length;i++){
	  String fileName=subFile[i].getName();
	   if(fileName.equals(id)){
             Scanner s= new Scanner(subFile[i]);
		title=s.nextLine();
		date=s.next();
	  	author=s.next();
			 while(s.hasNextLine())
	content+=s.nextLine();
	   }
	}
%>
<table width=1200px align=center>
	<tr >
		<td align=center width="1500"><%=title%></td>
		<td>&nbsp;&nbsp;</td>
		</tr>
<tr>

	<td ><%=date%></td>
		<td width=100px><%=author%></td>
</tr>
<br>
		<tr><td colspan=10 width=100px>&nbsp;&nbsp;<%=content%></td></tr>
		</table>
</body>
	</html>