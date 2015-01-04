<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

 
<HTML><BODY>
  <%
    String yourName=(String)session.getValue("LogName");
    if (yourName.equals(null))
    {
    %>您还未登录
    <%
    }else
    {
    %>
    "<%=yourName%>"已经登录
    <%
    }
  %>
</BODY></HTML>
