<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>CreateNews</title>
</head>
<body>
<form action="NewsCreate2.jsp">
<table>
	<tr><td>���ű���<input type="text" name="newstitle" value="" maxlength="85"></td></tr>
	<tr><td>����ʱ��<input type="text" name="newstime" value=""></td></tr>
	<tr><td>������<input type="text" name="newsauthor" value=""></td></tr>
	<tr><td>��������<table><textarea rows="30" cols="140" name="newscontent"></textarea></td></tr>
	<tr><td><input type="submit" name="news" value="submit"></td></tr>
</table>
<a href="NewsIndex.jsp">back</a>
</form>	
	
</body>
</html>