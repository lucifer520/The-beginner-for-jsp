<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>Login</title>
   


  </head>
 
  <body>
   
   <s:form action="/login" method="post">
    <s:label value="系统登陆"></s:label>
    <s:textfield name="username" label="账号" />
    <s:password name="password" label="密码" />
    <s:submit value="登录" />
   </s:form>
 
  </body>
</html>
