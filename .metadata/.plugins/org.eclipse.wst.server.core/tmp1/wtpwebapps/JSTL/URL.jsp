<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>URL标签</title>
</head>
<body>
&It;c:import&It; 可以引用外部网站的网页比 &It;jsp:include&It; 只能导入站点的资源要强
<c:import url="http://www.baidu.com" charEncoding="utf-8" var="s"></c:import>
 ${s }
<br>
*******************************使用context代替url 就是先对路径**********************<br>

<a href="redirect.jsp"> redirect 重定位到forEach</a>
<br>

<br>

*******************************利用&It;c:url&It;标签形成一个href的地址在通过&It;a href="c:url 的var值"&It;转到forEach&It;/a&It;******
<br>
<c:url value="forEach.jsp" var="urls" scope="session">
  <c:param name="userw" value="sss"></c:param>

</c:url>

<a href="${urls }"> 转到forEach</a>
<br>
<br>
<font size="10" color="#ffgghh">
&It;c:import&It;属性：<br>
url,context,var(获得的资源存放处),scope,varReader(以reader形式存放var值),charEncoding
<br>
&It;c:url&It;属性：<br>
value(url的意思),var,scope,context
<br><br>
<br>
<br>
</font>





</body>
</html>