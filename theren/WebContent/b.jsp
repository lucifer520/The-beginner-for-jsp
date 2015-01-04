<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="theren.Calculator"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'handler.jsp' starting page</title>

</head>

<body>
    <%-- 表单参数封装到 bean --%>
    <jsp:useBean id="calculator" class="theren.Calculator" />

    <jsp:setProperty name="calculator" property="*" />

    <%-- 执行运算 --%>
    <%
        Calculator bean = (Calculator) pageContext
                .getAttribute("calculator");
        bean.calculate();
    %>

    <%-- 显示运算结果 --%>
    运算结果如下:
    <br>
    <jsp:getProperty name="calculator" property="firstNumber" />
    <jsp:getProperty name="calculator" property="operator" />
    <jsp:getProperty name="calculator" property="secondNumber" />
    =
    <jsp:getProperty name="calculator" property="result" />
</body>
</html>