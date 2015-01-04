<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forTokens</title>
</head>
<body>
<c:out value="**********************分割标签************************"></c:out>
<br>

<c:set var="text1">编程词典软件涵盖技术、函数、控件、实例、项目、方案、界面等所有开发内容，以及所有的实例程序，实例工具等内容。是程序开发人员高效的开发软件</c:set>
原字符串<c:out value="${text1 }"></c:out>：
<br>被分割后的字符串：<br><br>
<c:forTokens items="${text1 }" delims="、，。" var="items">
  ${items }<br>
</c:forTokens>
<br>
<font size="10">属性与forEach相同    只是多了一个delims表示分割时分割字符可以有很多个</font>
<c:import url="http://m.weather.com.cn/m/p5/weather1.htm"></c:import>

</body>
</html>