<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.ArrayList"%>
 <%@page import="java.util.HashMap" %>
<%@page isELIgnored="false" %>   <!-- 使用EL表达式 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
${header.host}
${header["user-agent"]}
</p>
<p>
<%String[] name={"苹果","橘子","桃子"};
request.setAttribute("fruit", name);
%>
${requestScope.fruit[1]}
</p>
<p>

<% ArrayList list=new ArrayList();
   list.add("苹果");
   list.add("橘子");
   session.setAttribute("fruitList",list);
%>
${sessionScope.fruitList[1]}
</p>
<p>
<% HashMap<String,String> map=new HashMap<String,String>();
   map.put("1","苹果");
   map.put("2","橘子");
   application.setAttribute("fruitMap", map);
%>
${applicationScope.fruitMap["1"]}

${applicationScope.fruitMap["1"] =="苹果" }
${empty applicationScope.fruitMap["3"]}
${empty applicationScope.fruitMap["1"]?"name为空":applicationScope.fruitMap["1"] }
</p>

<!-- initParam -->
<p>
${initParam.user }
</p>


<%-- <!-- Cookie -->
<p>
<% Cookie cookie=new Cookie("User","许涛"); 
   response.addCookie(cookie);
%>
${cookie.User.value}
</p> --%>

<!-- param -->
<p>
<input type="text" name="text1" id="text1">
${param.text1}
</p>
<!-- paramValue -->
<p>
<input type="text" name="text2" id="text2">
<input type="text" name="text2" id="text2">
<input type="text" name="text2" id="text2">
<input type="text" name="text2" id="text2">
${paramValues.text[2]}
</p>








</body>
</html>