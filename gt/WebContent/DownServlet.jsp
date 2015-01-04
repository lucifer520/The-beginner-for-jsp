
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="margin-top:width="500" border="1" align="center" cellpadding="0" cellspacing="0"
       bordercolor="#FFFFFF" bordercolorligth="#FFFFFF" bordercoloreddark="#FFCCCC">
       
       
       <tr>
       		<td width="29%" height="27" align="center">  标题</td>
       		<td width="14%" height="27" align="center"> 上传人 </td>
       		<td width="23%" height="27" align="center"> 上传时间</td>
       		<td width="6%"  height="27" align="center"> 下载</td>	
       </tr>
       <tr>
       <td heigth="29" align="center"> 新歌</td>
       <td align="center"> 小雨</td>
       <td align="center">2012年7月24日</td>
       <td align="center">
       
             <a href="DownServlet?path=<%=getServletContext().getRealPath("新歌.mp3") %>"> 下载</a>
       </td>
       </tr>
   
</table>

</body>
</html>