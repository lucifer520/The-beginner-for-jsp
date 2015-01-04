
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.*" %>

<HTML>
  <BODY>
  <%
    String Name=request.getParameter("UserName");

    session.putValue("LogName", Name);
  %>
  你的名字"<%=Name%>"已经写入session 
  <br>
  <a href='./Check_session.jsp'>check</a>
  </BODY>
</HTML>
